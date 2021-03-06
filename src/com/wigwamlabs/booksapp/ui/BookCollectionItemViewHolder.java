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

package com.wigwamlabs.booksapp.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.wigwamlabs.booksapp.CountView;
import com.wigwamlabs.booksapp.R;

public class BookCollectionItemViewHolder {
	public static View create(Context context) {
		final View view = LayoutInflater.from(context).inflate(R.layout.book_collection_item, null);
		final BookCollectionItemViewHolder holder = new BookCollectionItemViewHolder(view);
		view.setTag(holder);
		return view;
	}

	public static BookCollectionItemViewHolder from(View view) {
		return (BookCollectionItemViewHolder) view.getTag();
	}

	private final CountView mBookCount;
	private final CheckBox mIsMember;
	private final TextView mName;

	public BookCollectionItemViewHolder(View view) {
		mIsMember = (CheckBox) view.findViewById(R.id.is_member);
		mName = (TextView) view.findViewById(R.id.name);
		mBookCount = (CountView) view.findViewById(R.id.book_count);
	}

	public void update(boolean isMember, String name, int bookCount) {
		mIsMember.setChecked(isMember);
		mName.setText(name);
		mBookCount.setCount(bookCount);
	}
}
