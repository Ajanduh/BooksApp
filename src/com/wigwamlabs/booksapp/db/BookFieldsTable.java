/*
 * Copyright 2011 Jonas Bengtsson
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.wigwamlabs.booksapp.db;

import android.database.sqlite.SQLiteDatabase;

import com.wigwamlabs.booksapp.db.QueryBuilder.CreateQueryBuilder;

public final class BookFieldsTable {
	public static final String creators = "creators";
	public static final String description = "description";
	public static final String fulltitle = "fulltitle";
	public static final String n = "BookFields";
	public static final String notes = "notes";
	public static final String rowid = "rowid";

	public static void create(SQLiteDatabase db) {
		final CreateQueryBuilder t = QueryBuilder.createFts3(n);
		// order for result ordering, @see Bookslist#searchAny()
		t.text(fulltitle, null);
		t.text(creators, null);
		t.text(description, null);
		t.text(notes, null);
		t.execute(db);
	}

	public static void drop(SQLiteDatabase db) {
		db.execSQL(QueryBuilder.drop(n));
	}
}