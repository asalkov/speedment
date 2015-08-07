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

import com.speedment.codegen.lang.interfaces.Callable;
import com.speedment.codegen.lang.interfaces.Copyable;
import com.speedment.codegen.lang.interfaces.HasName;
import com.speedment.codegen.lang.models.implementation.JavadocTagImpl;
import java.util.Optional;
import java.util.function.Supplier;

/**
 * A model that represents a specific tag in a {@link Javadoc} block.
 * 
 * @author  Emil Forslund
 * @see     Javadoc
 */
public interface JavadocTag extends Copyable<JavadocTag>, HasName<JavadocTag>, 
    Callable<JavadocTag> {
    
    /**
     * Sets the value of this javadoc tag. In the following examples, the value
     * is the "foo" part:
     * <pre>
     *     &#64;param foo bar
     *     &#64;return foo
     * </pre>
     * 
     * @param value  the new value
     * @return       a reference to this model
     */
    JavadocTag setValue(String value);
    
    /**
     * Returns the value of this javadoc tag. In the following examples, the 
     * value is the "foo" part:
     * <pre>
     *     &#64;param foo bar
     *     &#64;return foo
     * </pre>

     * @return  the value part of the tag or <code>empty</code> if none exists
     */
    Optional<String> getValue();
    
    /**
     * Sets the text of this javadoc tag. In the following examples, the text
     * is the "bar" part:
     * <pre>
     *     &#64;param foo bar
     *     &#64;return foo
     * </pre>
     * 
     * @param text  the new text
     * @return      a reference to this model
     */
    JavadocTag setText(String text);
    
    /**
     * Returns the text of this javadoc tag. In the following examples, the 
     * text is the "bar" part:
     * <pre>
     *     &#64;param foo bar
     *     &#64;return foo
     * </pre>

     * @return  the text part of the tag or <code>empty</code> if none exists
     */
	Optional<String> getText();
    
    enum Factory { INST;
        private Supplier<JavadocTag> supplier = () -> new JavadocTagImpl(null);
    }

    static JavadocTag of(String name) {
        return Factory.INST.supplier.get().setName(name);
    }
    
    static JavadocTag of(String name, String text) {
        return Factory.INST.supplier.get().setName(name).setText(text);
    }
    
    static JavadocTag of(String name, String value, String text) {
        return Factory.INST.supplier.get().setName(name).setValue(value).setText(text);
    }
    
    static void setSupplier(Supplier<JavadocTag> a) {
        Factory.INST.supplier = a;
    }
}