/*
 * Copyright 2011 Benny Colyn
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.github.bcolyn.jmediahash.index.mvp;

import java.util.Iterator;
import java.util.Stack;

class NodeIterator<K> implements Iterator<Node<K>>{
    private final Stack<Node<K>> toDo = new Stack<Node<K>>();

    public NodeIterator(Node<K> root) {
        toDo.push(root);
    }

    @Override
    public boolean hasNext() {
        return toDo.size() > 0;
    }

    @Override
    public Node<K> next() {
        Node<K> current = toDo.pop();
        for (int i = 0; i < current.getChildren().length; i++) {
            Node<K> child = current.getChildren()[i];
            if (child != null){
                toDo.push(child);
            }
        }
        return current;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Not supported");
    }
}
