/*
 * Copyright 2003-2015 the original author or authors.
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
package groovy.bugs

/**
 * Test to fix the Jira issues GROOVY-1018 and GROOVY-732.
 * Access to a static field member by a class name:
 *      ClassName.fieldName or ClassName.@fieldName.
 *
 * @author Pilho Kim
 * @version $Revision$
 */

class Groovy1018_Bug extends GroovyTestCase { 

    public static Object Class = "bar" 

    // todo: GROOVY-1018
    void testGetPublicStaticField() {
        Groovy1018_Bug.Class = 'bar'
        def a = new Groovy1018_Bug()
        println( a.Class )
        println( a.@Class )
        println( Groovy1018_Bug.Class )
        println( Groovy1018_Bug.@Class )
        assert a.Class == "bar" && a.@Class == "bar"
        assert Groovy1018_Bug.Class == "bar" && Groovy1018_Bug.@Class == "bar"
    }

    // todo: GROOVY-732
    void testSetPublicStaticField() {
        Groovy1018_Bug.Class = 'bar-'
        assert Groovy1018_Bug.Class == "bar-" && Groovy1018_Bug.@Class == "bar-"
    }

} 
