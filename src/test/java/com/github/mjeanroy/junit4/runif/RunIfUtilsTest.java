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

import static org.assertj.core.api.Assertions.assertThat;

import java.lang.reflect.Method;

import com.github.mjeanroy.junit4.runif.fixtures.IgnoreChildClass;
import com.github.mjeanroy.junit4.runif.fixtures.IgnoreTestClass;
import com.github.mjeanroy.junit4.runif.fixtures.IgnoreTestMethodClass;
import com.github.mjeanroy.junit4.runif.fixtures.NotIgnoreTestClass;
import org.junit.Test;

public class RunIfUtilsTest {
	@Test
	public void it_should_return_true_if_class_is_ignored() {
		boolean isIgnored = RunIfUtils.isIgnored(IgnoreTestClass.class);
		assertThat(isIgnored).isTrue();
	}

	@Test
	public void it_should_return_false_if_class_does_not_have_run_if_annotation() {
		boolean isIgnored = RunIfUtils.isIgnored(IgnoreTestMethodClass.class);
		assertThat(isIgnored).isFalse();
	}

	@Test
	public void it_should_return_false_if_class_is_not_ignored() {
		boolean isIgnored = RunIfUtils.isIgnored(NotIgnoreTestClass.class);
		assertThat(isIgnored).isFalse();
	}

	@Test
	public void it_should_return_true_if_class_is_ignored_because_super_class_is_annotated() {
		boolean isIgnored = RunIfUtils.isIgnored(IgnoreChildClass.class);
		assertThat(isIgnored).isTrue();
	}

	@Test
	public void it_should_return_true_if_method_is_ignored() throws Exception {
		Method method = IgnoreTestMethodClass.class.getMethod("ignored_test");
		boolean isIgnored = RunIfUtils.isIgnored(method);
		assertThat(isIgnored).isTrue();
	}

	@Test
	public void it_should_return_false_if_method_does_not_have_run_if_annotation() throws Exception {
		Method method = IgnoreTestMethodClass.class.getMethod("not_with_annotation_test");
		boolean isIgnored = RunIfUtils.isIgnored(method);
		assertThat(isIgnored).isFalse();
	}

	@Test
	public void it_should_return_false_if_method_is_not_ignored() throws Exception {
		Method method = IgnoreTestMethodClass.class.getMethod("not_ignored_test");
		boolean isIgnored = RunIfUtils.isIgnored(method);
		assertThat(isIgnored).isFalse();
	}
}
