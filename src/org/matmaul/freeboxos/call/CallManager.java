package org.matmaul.freeboxos.call;

import java.util.Collections;
import java.util.List;

import org.matmaul.freeboxos.FreeboxException;
import org.matmaul.freeboxos.internal.Response.EmptyResponse;
import org.matmaul.freeboxos.internal.RestManager;

public class CallManager {
	protected RestManager restManager;

	public CallManager(RestManager restManager) {
		this.restManager = restManager;
	}

	public List<CallEntry> getCallEntries() throws FreeboxException {
		List<CallEntry> l = restManager.get("call/log/", CallResponses.CallEntriesResponse.class);
		if (l == null) {
			l = Collections.emptyList();
		}
		return l;
	}
	
	public CallEntry getCallEntry(long id) throws FreeboxException {
		return restManager.get("call/log/" + id, CallResponses.CallEntryResponse.class);
	}
	
	public CallEntry setCallEntry(CallEntry entry) throws FreeboxException {
		return restManager.put("call/log/" + entry.getId(), restManager.createJsonEntity(entry), CallResponses.CallEntryResponse.class);
	}

	public void deleteCallEntry(CallEntry entry) throws FreeboxException {
		restManager.delete("call/log/" + entry.getId(), EmptyResponse.class);
	}

	public void deleteAllCallEntries() throws FreeboxException {
		restManager.get("call/log/delete_all", EmptyResponse.class);
	}

	public void markAllCallEntriesAsRead() throws FreeboxException {
		restManager.get("call/log/mark_all_as_read", EmptyResponse.class);
	}

}
