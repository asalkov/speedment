/**
 *
 * Copyright (c) 2006-2015, Speedment, Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); You may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.speedment.codegen.lang.models;

import com.speedment.codegen.lang.interfaces.Copyable;
import com.speedment.codegen.lang.interfaces.HasType;
import com.speedment.codegen.lang.interfaces.HasValue;
import com.speedment.codegen.lang.models.implementation.AnnotationUsageImpl;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

/**
 * A model that represents the usage of a particular annotation in code.
 * 
 * @author  Emil Forslund
 * @see     Annotation
 */
public interface AnnotationUsage extends Copyable<AnnotationUsage>, 
    HasType<AnnotationUsage>, HasValue<AnnotationUsage> {
    
    /**
     * Use the specified key-value pair when referencing the annotation. If you
     * only want to show a single value without any key, consider using the
     * {@link #set(com.speedment.codegen.lang.models.Value) set()} method.
     * 
     * @param key  the key
     * @param val  the value
     * @return     a reference to this model
     */
    AnnotationUsage put(String key, Value<?> val);
    
    /**
     * Returns a list of all the key-value pairs in this model.
     * 
     * @return  all key-value pairs 
     */
    List<Map.Entry<String, Value<?>>> getValues();
    
    enum Factory { INST;
        private Supplier<AnnotationUsage> supplier = () -> new AnnotationUsageImpl(null);
    }

    static AnnotationUsage of(Type type) {
        return Factory.INST.supplier.get().set(type);
    }
    
    static void setSupplier(Supplier<AnnotationUsage> a) {
        Factory.INST.supplier = a;
    }
}