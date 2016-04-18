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
package com.insightml.data.samples;

import java.io.Serializable;

public interface ISample extends Serializable, Comparable<ISample> {

    int getId();

    <E> E[] getExpected();

    <E> E getExpected(int labelIndex);

    float getWeight(int labelIndex);

    String getComment();

    void writeInfo(ISampleInfoBuilder builder, Iterable<? extends ISample> instances);

}
