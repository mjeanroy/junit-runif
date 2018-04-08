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

import com.github.mjeanroy.junit4.runif.fixtures.IgnoreTestClass;
import com.github.mjeanroy.junit4.runif.fixtures.IgnoreTestMethodClass;
import org.junit.Test;
import org.junit.internal.builders.IgnoredClassRunner;
import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.notification.RunNotifier;

import static com.github.mjeanroy.junit4.runif.tests.ReflectionTestUtils.readField;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class RunIfRunnerTest {

	@Test
	public void it_should_get_ignore_class_runner() throws Exception {
		RunIfRunner runner = new RunIfRunner(IgnoreTestClass.class);
		Runner delegatedRunner = readField(runner, "delegate");
		assertThat(delegatedRunner).isExactlyInstanceOf(IgnoredClassRunner.class);
	}

	@Test
	public void it_should_get_ignore_test_class_runner() throws Exception {
		RunIfRunner runner = new RunIfRunner(IgnoreTestMethodClass.class);
		Runner delegatedRunner = readField(runner, "delegate");
		assertThat(delegatedRunner).isExactlyInstanceOf(RunIfBlockJunit4ClassRunner.class);
	}

	@Test
	public void it_should_delegate_the_test_description() throws Exception {
		RunIfRunner runner1 = new RunIfRunner(IgnoreTestClass.class);
		Description description1 = runner1.getDescription();
		assertThat(description1).isNotNull();
		assertThat(description1.getDisplayName()).isEqualTo("com.github.mjeanroy.junit4.runif.fixtures.IgnoreTestClass");

		RunIfRunner runner2 = new RunIfRunner(IgnoreTestMethodClass.class);
		Description description2 = runner2.getDescription();
		assertThat(description2).isNotNull();
		assertThat(description2.getDisplayName()).isEqualTo("com.github.mjeanroy.junit4.runif.fixtures.IgnoreTestMethodClass");
	}

	@Test
	public void it_should_delegate_run_test() throws Exception {
		RunIfRunner runner1 = new RunIfRunner(IgnoreTestClass.class);
		RunNotifier runNotifier = mock(RunNotifier.class);
		runner1.run(runNotifier);
		verify(runNotifier).fireTestIgnored(any(Description.class));
	}
}
