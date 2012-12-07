package com.jkali.client.command;

import org.jrebirth.core.service.ServiceWaveListener;
import org.jrebirth.core.wave.Wave;
import org.jrebirth.core.wave.WaveListener;
import org.jrebirth.core.wave.Wave.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class SnapShotListener implements WaveListener{
	
	 /** The class logger. */
    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceWaveListener.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public void waveCreated(final Wave wave) {
        // Nothing to do yet
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void waveSent(final Wave wave) {
        // Nothing to do yet
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void waveProcessed(final Wave wave) {
        // Nothing to do yet
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void waveCancelled(final Wave wave) {
        // Nothing to do yet
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void waveConsumed(final Wave wave) {
        if (wave.getRelatedWave() != null) {
            // Return wave has been consumed, so the triggered wave can be consumed too
            LOGGER.trace(wave.getRelatedClass().getSimpleName() + " Consumes wave " + wave.getRelatedWave().toString());
    
            wave.getRelatedWave().setStatus(Status.Consumed);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void waveFailed(final Wave wave) {
        // Nothing to do yet
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void waveDestroyed(final Wave wave) {
        // Nothing to do yet
    }


}
