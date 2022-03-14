package org.edx.mobile.view;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.edx.mobile.base.BaseFragmentActivity;
import org.edx.mobile.interfaces.NetworkObserver;
import org.edx.mobile.interfaces.NetworkSubject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collection;

/**
 * Test NetworkSubject implementations for correctness
 */
public class NetworkSubjectTest {

    @Mock
    public NetworkSubject networkSubject;

    @Test
    public void test() {
        NetworkObserverTest networkObserver = new NetworkObserverTest();
        networkSubject.registerNetworkObserver(networkObserver);
        assertTrue(networkObserver.isOnline);
        networkSubject.notifyNetworkDisconnect();
        assertFalse(networkObserver.isOnline);
        networkSubject.notifyNetworkConnect();
        assertTrue(networkObserver.isOnline);
        networkSubject.unregisterNetworkObserver(networkObserver);
        assertTrue(networkObserver.isOnline);
        networkSubject.notifyNetworkDisconnect();
        assertTrue(networkObserver.isOnline);
    }

    private static class NetworkObserverTest implements NetworkObserver {
        boolean isOnline = true;

        @Override
        public void onOnline() {
            isOnline = true;
        }

        @Override
        public void onOffline() {
            isOnline = false;
        }
    }
}
