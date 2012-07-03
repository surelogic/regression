package de.kvconnect.bundle.common;

import java.io.IOException;
import java.util.Properties;

import junit.framework.Assert;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kvconnect.bundle.common.PropertiesUtils;

public class PropertiesUtilsTest
{
	private static final Logger LOG = LoggerFactory.getLogger(PropertiesUtilsTest.class);
	
	private static final String TEST_RESOURCE_PATH = PathUtils.assemblePath("src", "test", "resources");

	private static final String MERGE_PROPERTIES_TEST_DATA = PathUtils.assemblePath(TEST_RESOURCE_PATH,
		"merge-properties-test-data");

	private static final String MERGE_PROPERTIES_TEST_FILE_1 = PathUtils.assemblePath(MERGE_PROPERTIES_TEST_DATA,
		"PropFile1.properties");
	private static final String MERGE_PROPERTIES_TEST_FILE_2 = PathUtils.assemblePath(MERGE_PROPERTIES_TEST_DATA,
		"PropFile2.properties");
	private static final String MERGE_PROPERTIES_TEST_FILE_RESULT = PathUtils.assemblePath(MERGE_PROPERTIES_TEST_DATA,
		"PropFileMerge1_2.properties");

	@Test
	public final void testMergeProperties()
	{
		LOG.info("--------------------------------------------------");
		LOG.info("testMergeProperties()");
		LOG.info("--------------------------------------------------");

		Properties testProp1 = new Properties();
		Properties testProp2 = new Properties();
		Properties testProp3 = new Properties();
		Properties testProp4 = new Properties();

		testProp1.setProperty("TestKey1", "TestValue1");
		testProp1.setProperty("TestKey2", "TestValue2");
		testProp1.setProperty("TestKeySame", "TestValueProp1");

		testProp2.setProperty("TestKeySame", "TestValueProp2");
		testProp2.setProperty("TestKey4", "TestValue4");
		testProp2.setProperty("TestKey5", "TestValue5");

		testProp3.setProperty("TestKey1", "TestValue1");
		testProp3.setProperty("TestKey2", "TestValue2");
		testProp3.setProperty("TestKeySame", "TestValueProp2");
		testProp3.setProperty("TestKey4", "TestValue4");
		testProp3.setProperty("TestKey5", "TestValue5");

		testProp4.setProperty("TestKey1", "TestValue1");
		testProp4.setProperty("TestKey2", "TestValue2");
		testProp4.setProperty("TestKeySame", "TestValueProp1");
		testProp4.setProperty("TestKey4", "TestValue4");
		testProp4.setProperty("TestKey5", "TestValue5");

		Properties mergedProps = PropertiesUtils.mergeProperties(testProp1, testProp2);
		Assert.assertEquals(testProp3, mergedProps);

		mergedProps = PropertiesUtils.mergeProperties(testProp2, testProp1);
		Assert.assertEquals(testProp4, mergedProps);
	}

	@Test
	public final void testMergePropertiesFiles() throws IOException
	{
		LOG.info("--------------------------------------------------");
		LOG.info("testMergePropertiesFiles()");
		LOG.info("--------------------------------------------------");

		Properties propFile1 = PropertiesUtils.loadProperties(MERGE_PROPERTIES_TEST_FILE_1);
		Properties propFile2 = PropertiesUtils.loadProperties(MERGE_PROPERTIES_TEST_FILE_2);
		Properties propFile3 = PropertiesUtils.loadProperties(MERGE_PROPERTIES_TEST_FILE_RESULT);

		Properties mergedProps = PropertiesUtils.mergeProperties(propFile1, propFile2);
		Assert.assertEquals(propFile3, mergedProps);
	}

}
