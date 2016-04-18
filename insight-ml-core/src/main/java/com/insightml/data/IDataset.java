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

import com.insightml.data.samples.ISample;
import com.insightml.utils.IArguments;
import com.insightml.utils.ui.reports.IReporter;

public interface IDataset<S extends ISample, E, O> extends IReporter {

    String getName();

    String getDescription();

    Iterable<S> loadAll();

    Iterable<S> loadTraining(Integer labelIndex);

    Iterable<S> loadValidation();

    Iterable<S> loadTest(Integer labelIndex);

    IPreprocessingPipeline<S, E> pipeline(Iterable<S> training, Integer labelIndex,
            Iterable<S>... instances);

    FeaturesConfig<S, O> getFeaturesConfig(IArguments arguments);

    void close();

}
