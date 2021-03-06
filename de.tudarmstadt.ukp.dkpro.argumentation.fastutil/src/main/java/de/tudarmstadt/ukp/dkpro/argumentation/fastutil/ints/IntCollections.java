/*
 * Copyright 2016
 * Ubiquitous Knowledge Processing (UKP) Lab
 * Technische Universität Darmstadt
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
package de.tudarmstadt.ukp.dkpro.argumentation.fastutil.ints;

import it.unimi.dsi.fastutil.ints.IntCollection;
import it.unimi.dsi.fastutil.ints.IntOpenHashSet;
import it.unimi.dsi.fastutil.ints.IntSet;

/**
 * A utility class for manipulating {@link IntCollection} elements.
 *
 * @author Todd Shore
 */
public final class IntCollections
{

    public static final IntSet createAllElementSet(
            final Iterable<? extends IntCollection> collections)
    {
        final IntOpenHashSet result = new IntOpenHashSet();
        for (final IntCollection collection : collections) {
            result.addAll(collection);
        }
        return result;
    }

    private IntCollections()
    {
        // Avoid instantiation
    }

}
