package com.jkali.client.service;

import com.jkali.client.entity.IPage;
import com.jkali.client.entity.account.Manual;
import com.jkali.client.page.PageWave;
import com.jkali.client.ui.manual.ManualPageModel;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import org.javafxdata.datasources.Format;
import org.javafxdata.datasources.reader.DataSourceReader;
import org.javafxdata.datasources.reader.FileSource;
import org.javafxdata.datasources.reader.RestRequestBuilder;


import org.jrebirth.core.exception.CoreException;
import org.jrebirth.core.service.ServiceBase;
import org.jrebirth.core.wave.Wave;
import org.jrebirth.core.wave.WaveTypeBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXException;

/**
 * The class <strong>AccountService</strong>. TODO To complete
 * 
 * @author Paul
 * 
 */
public final class AccountService extends ServiceBase {

    /** Wave type use to load events. */
    public static final WaveTypeBase DO_GET_MANUAL_LIST =  WaveTypeBase.build("GET_MANUAL_LIST", PageWave.PAGE);

    /** Wave type to return events loaded. */
    public static final WaveTypeBase BACK_GET_MANUAL_LIST =  WaveTypeBase.build("BACK_GET_MANUAL_LIST", PageWave.READER);

    /** The class logger. */
    protected final Logger logger = LoggerFactory.getLogger(getClass());
    

    /**
     * {@inheritDoc}
     */
    @Override
    public void ready() throws CoreException {
        super.ready();
        registerService(DO_GET_MANUAL_LIST, BACK_GET_MANUAL_LIST, PageWave.PAGE);
    }
    
    public DataSourceReader getManualList(Wave wave){
        RestRequestBuilder request = new RestRequestBuilder("http://localhost:8080/spg").format(Format.XML);
        //DataSourceReader reader = new FileSource(getClass().getResourceAsStream("menu.xml"));
        request.path("main!list.action").queryParam("pageIndex", "1");
        DataSourceReader reader =request.build();
        //stream = reader.getInputStream();
        
        return reader;
    }

}
