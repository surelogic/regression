package testSpring3_1_0M1;

import static org.hamcrest.Matchers.hasItems;

import static org.junit.Assert.assertThat;

public class NestedBeansElementAttributeRecursionTests {
	public void defaultMerge() {
		/*
		DefaultListableBeanFactory bf = new DefaultListableBeanFactory();
		new XmlBeanDefinitionReader(bf).loadBeanDefinitions(
				new ClassPathResource("NestedBeansElementAttributeRecursionTests-merge-context.xml", this.getClass()));
        */
		TestBean topLevel = null;//bf.getBean("topLevelConcreteTestBean", TestBean.class);
		// has the concrete child bean values
		assertThat(topLevel.getSomeList(), hasItems("charlie", "delta"));
		/*
		// but does not merge the parent values
		assertThat(topLevel.getSomeList(), not(hasItems("alpha", "bravo")));

		TestBean firstLevel = bf.getBean("firstLevelNestedTestBean", TestBean.class);
		// merges all values
		assertThat(firstLevel.getSomeList(),
				hasItems("charlie", "delta", "echo", "foxtrot"));

		TestBean secondLevel = bf.getBean("secondLevelNestedTestBean", TestBean.class);
		// merges all values
		assertThat(secondLevel.getSomeList(),
				hasItems("charlie", "delta", "echo", "foxtrot", "golf", "hotel"));
		*/
	}
}
