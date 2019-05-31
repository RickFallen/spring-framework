package org.springframework.tests.beans;

import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

public class MyTest {
	/**
	 * 整个过程就分为三个步骤：资源定位、装载、注册
	 *
	 *
	 * 注册。向 IoC 容器注册在第二步解析好的 BeanDefinition，这个过程是通过 BeanDefinitionRegistry 接口来实现的。
	 * 在 IoC 容器内部其实是将第二个过程解析得到的 BeanDefinition 注入到一个 HashMap 容器中，
	 * IoC 容器就是通过这个 HashMap 来维护这些 BeanDefinition 的。
	 */
	@Test
	public void bean1(){
		/**
		 * 资源加载
		 */
		ClassPathResource resource = new ClassPathResource("bean.xml"); // 获取资源
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory(); // 获取 BeanFactory
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory); // 根据新建的 BeanFactory 创建一个 BeanDefinitionReader 对象，该 Reader 对象为资源的解析器
		reader.loadBeanDefinitions(resource); // 装载资源


		/**
		 * 获取bean
 		 */
		Object firstBean = factory.getBean("firstBean");
		System.out.println(firstBean);
	}
}
