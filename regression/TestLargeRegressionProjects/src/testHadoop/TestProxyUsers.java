package testHadoop;

import java.util.*;

public class TestProxyUsers {
	private static final String REAL_USER_NAME = "proxier";
	private static final String PROXY_USER_NAME = "proxied_user";
	private static final String AUTHORIZED_PROXY_USER_NAME = "authorized_proxied_user";
	private static final String[] GROUP_NAMES =
			new String[] { "foo_group" };
	private static final String[] NETGROUP_NAMES =
			new String[] { "@foo_group" };
	private static final String[] OTHER_GROUP_NAMES =
			new String[] { "bar_group" };
	private static final String[] SUDO_GROUP_NAMES =
			new String[] { "sudo_proxied_user" };
	private static final String PROXY_IP = "1.2.3.4";
	private static final String PROXY_IP_RANGE = "10.222.0.0/16,10.113.221.221";

	public void testWithDuplicateProxyGroups() throws Exception {
		Configuration conf = new Configuration();
		conf.set(
				DefaultImpersonationProvider.getTestProvider().
				getProxySuperuserGroupConfKey(REAL_USER_NAME),
				StringUtils.join(",", Arrays.asList(GROUP_NAMES,GROUP_NAMES)));
		/*
		conf.set(
				DefaultImpersonationProvider.getTestProvider().
				getProxySuperuserIpConfKey(REAL_USER_NAME),
				PROXY_IP);
		ProxyUsers.refreshSuperUserGroupsConfiguration(conf);

		Collection<String> groupsToBeProxied = 
				ProxyUsers.getDefaultImpersonationProvider().getProxyGroups().get(
						DefaultImpersonationProvider.getTestProvider().
						getProxySuperuserGroupConfKey(REAL_USER_NAME));

		assertEquals (1,groupsToBeProxied.size());
		 */
	}
}
