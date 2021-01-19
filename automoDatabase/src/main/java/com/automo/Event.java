/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.automo;

import com.google.common.eventbus.Subscribe;
import lombok.Data;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;

/**
 * @author ylltrazoaar, the always and everywhere
 */
public class Event {

	private static final Logger LOG = LogManager.getLogger(Event.class);

	@Subscribe
	public void logEvent(Object o) {
		LOG.info("Event of type {} received", o.getClass());
	}

	@Data
	public static class ShowFrameEvent extends Event {
		private final JFrame frame;
	}
}
