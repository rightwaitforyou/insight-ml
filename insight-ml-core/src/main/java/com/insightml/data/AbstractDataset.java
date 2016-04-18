/*
 * Copyright (C) 2016 Stefan Henß
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.insightml.data;

import java.util.LinkedList;
import java.util.List;

import com.insightml.data.samples.ISample;
import com.insightml.utils.Pair;
import com.insightml.utils.types.AbstractModule;

public abstract class AbstractDataset<I extends ISample, E, P> extends AbstractModule implements IDataset<I, E, P> {

	public AbstractDataset() {
	}

	public AbstractDataset(final String name) {
		super(name);
	}

	@Override
	public Iterable<I> loadValidation() {
		throw new IllegalAccessError();
	}

	@Override
	public Iterable<I> loadTest(final Integer labelIndex) {
		throw new IllegalAccessError();
	}

	@Override
	public Iterable<I> loadAll() {
		throw new IllegalAccessError();
	}

	@Override
	public final PreprocessingPipeline<I, E> pipeline(final Iterable<I> training, final Integer labelIndex,
			final Iterable<I>... instances) {
		return PreprocessingPipeline.create(getFeaturesConfig(null), training, labelIndex, instances);
	}

	@Override
	public String getReport() {
		final List<Pair<String, String>> fields = new LinkedList<>();
		fields.add(new Pair<>("Name", getName()));
		fields.add(new Pair<>("Description", getDescription()));
		return fields.toString();
	}

	@Override
	public void close() {
	}

}
