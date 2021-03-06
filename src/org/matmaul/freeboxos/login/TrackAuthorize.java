/*
 * Copyright (c) 2013, Mathieu Velten. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301  USA
 */
package org.matmaul.freeboxos.login;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonAutoDetect.Visibility;

/**
 * @author matmaul
 * 
 */
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class TrackAuthorize {
	protected String status;
	protected String challenge;
	
	/**
	 * @return the status
	 */
	//public String getStatus() {
	//	return status;
	//}
	
	public TrackAuthorizeStatus getStatus() {
		return TrackAuthorizeStatus.valueOf(status.toUpperCase());
	}
	
	public String getStatusAsString() {
		switch (getStatus()) {
		case DENIED: 
			return "Authorization request denied by user";
		case TIMEOUT: 
			return "Authorization request not handled in time";
		case GRANTED:
			return "Valid appToken";
		case PENDING:
			return "Processing authorization request";
		default: 
			return "Invalid or revocked appToken";
		}
	}
	
	/**
	 * @return the challenge
	 */
	public String getChallenge() {
		return challenge;
	}
}
