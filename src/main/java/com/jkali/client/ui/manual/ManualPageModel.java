package com.jkali.client.ui.manual;

import com.jkali.client.AppWaves;
import com.jkali.client.page.AbstractPageModel;
import com.jkali.client.entity.AuditableEntity;
import com.jkali.client.entity.IPage;
import com.jkali.client.entity.account.Manual;
import com.jkali.client.service.AccountService;
import java.util.List;
import org.javafxdata.datasources.provider.XMLDataSource;
import org.javafxdata.datasources.reader.DataSourceReader;
import org.javafxdata.datasources.reader.FileSource;
import org.jrebirth.core.wave.Wave;
import org.jrebirth.core.wave.WaveBuilder;
import org.jrebirth.core.wave.WaveData;
import org.jrebirth.core.wave.WaveItem;
import org.jrebirth.core.wave.WaveType;
import org.jrebirth.core.wave.WaveTypeBase;



/**
 * The class <strong>ClassicModel</strong>.
 * 
 * @author Sébastien Bordes
 * 
 */
public final class ManualPageModel extends AbstractPageModel<ManualPageModel, ManualPageView, Manual> {

    
    ManualPageModel pagemodel;
    @Override
    protected void customInitialize() {
        listen(AccountService.BACK_GET_MANUAL_LIST);
      
    }
    
    /**
     * Call when event are loaded.
     * 
     * @param eventList the list of events loaded
     * 
     * @param wave the wave received
     */
    public void backGetManualList(final IPage<Manual> page, final Wave wave) {
        pagemodel=(ManualPageModel)page;
    }

    @Override
    protected void customInitializeInnerModels() {
        
    }

    @Override
    protected void processAction(Wave wave) {
       
    
    }
   

    

}
