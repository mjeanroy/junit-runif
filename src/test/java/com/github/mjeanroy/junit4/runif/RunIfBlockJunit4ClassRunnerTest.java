/**
 * The MIT License (MIT)
 *
 * Copyright (c) 2018 Mickael Jeanroy
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.github.mjeanroy.junit4.runif;

import com.github.mjeanroy.junit4.runif.fixtures.IgnoreTestMethodClass;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.model.FrameworkMethod;

import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.assertThat;

public class RunIfBlockJunit4ClassRunnerTest {

	private RunIfBlockJunit4ClassRunner runner;

	@Before
	public void setUp() throws Exception {
		runner = new RunIfBlockJunit4ClassRunner(IgnoreTestMethodClass.class);
	}

	@Test
	public void it_should_return_return_true_if_method_is_ignored() throws Exception {
		Method method = IgnoreTestMethodClass.class.getMethod("ignored_test");
		FrameworkMethod frameworkMethod = new FrameworkMethod(method);
		assertThat(runner.isIgnored(frameworkMethod)).isTrue();
	}

	@Test
	public void it_should_return_return_false_if_method_does_not_have_annotation() throws Exception {
		Method method = IgnoreTestMethodClass.class.getMethod("not_with_annotation_test");
		FrameworkMethod frameworkMethod = new FrameworkMethod(method);
		assertThat(runner.isIgnored(frameworkMethod)).isFalse();
	}

	@Test
	public void it_should_return_return_false_if_method_is_not_ignored() throws Exception {
		Method method = IgnoreTestMethodClass.class.getMethod("not_ignored_test");
		FrameworkMethod frameworkMethod = new FrameworkMethod(method);
		assertThat(runner.isIgnored(frameworkMethod)).isFalse();
	}
}
