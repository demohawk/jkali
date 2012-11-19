/**
 * Copyright JRebirth.org © 2011-2012 
 * Contact : sebastien.bordes@jrebirth.org
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
package com.jkali.client.application;


import com.jkali.client.ui.manual.ManualPageModel;
import org.jrebirth.core.facade.UniqueKey;
import org.jrebirth.core.ui.InnerModels;
import org.jrebirth.core.ui.Model;

/**
 * The enumeration <strong>WorkbenchInnerModels</strong>.
 * 
 * Declare inner models contained by WorkbenchModel
 * 
 * @author Sébastien Bordes
 */
public enum MenuPageInnerModels implements InnerModels {

    /** The controls UI. */
    Manual(ManualPageModel.class);



    /** The model class of the inner model. */
    private final Class<? extends Model> modelClass;

    /**
     * Default Constructor.
     * 
     * @param modelClass the class to set
     */
    MenuPageInnerModels(final Class<? extends Model> modelClass) {
        this.modelClass = modelClass;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Class<? extends Model> getModelClass() {
        return this.modelClass;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey getKey() {
        return null;
    }

}
