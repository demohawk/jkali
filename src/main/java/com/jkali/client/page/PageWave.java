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
package com.jkali.client.page;

import com.jkali.client.entity.AuditableEntity;
import com.jkali.client.entity.IPage;
import java.io.File;
import java.io.InputStream;
import java.util.List;
import org.javafxdata.datasources.reader.DataSourceReader;
import org.jrebirth.core.event.Event;
import org.jrebirth.core.util.ClassUtility;
import org.jrebirth.core.wave.Wave;
import org.jrebirth.core.wave.WaveItem;
import org.jrebirth.core.wave.WaveTypeBase;

/**
 * The class <strong>EditorWave</strong>.
 * 
 * @author Sébastien Bordes
 */
public interface PageWave<T> {

      /*************************************************************************/
    /** Wave Types **/
    /*************************************************************************/

    /** Trigger a Unload wave. */
    WaveTypeBase DO_POST_PAGE = WaveTypeBase.build("GET_NEXT_PAGE");

    /** Trigger a Play wave. */
    WaveTypeBase DO_FIRST =  WaveTypeBase.build("PLAY");

    /** Trigger a Next wave. */
    WaveTypeBase DO_NEXT =  WaveTypeBase.build("NEXT");

    /** Trigger a Previous wave. */
    WaveTypeBase DO_PREVIOUS =  WaveTypeBase.build("PREVIOUS");

    /** Trigger a Stop wave. */
    WaveTypeBase DO_STOP =  WaveTypeBase.build("STOP");

    /** Wave used to display info into the properties view. */
    WaveTypeBase DO_SELECT_EVENT =  WaveTypeBase.build("EVENT_SELECTED");

    /** Wave type used to return the event currently processed. */
    WaveTypeBase RE_EVENT_PROCESSED =  WaveTypeBase.build("EVENT_PROCESSED");


    WaveItem<IPage> PAGE = WaveItem.build();
    WaveItem<Wave> WAVE = WaveItem.build();

    WaveItem<Object> OBJECT = WaveItem.build();
    
    WaveItem<InputStream> STREAM = WaveItem.build();
    
    WaveItem<DataSourceReader> READER = WaveItem.build();

}

