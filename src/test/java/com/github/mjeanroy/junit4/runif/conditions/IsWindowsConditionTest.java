/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2018-2026 Mickael Jeanroy
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

package com.github.mjeanroy.junit4.runif.conditions;

import org.junit.Test;

import static com.github.mjeanroy.junit4.runif.conditions.JavaTestingUtils.withOsName;
import static org.assertj.core.api.Assertions.assertThat;

public class IsWindowsConditionTest {

	@Test
	public void it_should_return_true_with_windows_11() {
		withOsName("Windows 11", new Runnable() {
				@Override
				public void run() {
					assertThat(evaluate()).isTrue();
				}
			}
		);
	}

	@Test
	public void it_should_return_true_with_windows_10() {
		withOsName("Windows 10", new Runnable() {
				@Override
				public void run() {
					assertThat(evaluate()).isTrue();
				}
			}
		);
	}

	@Test
	public void it_should_return_true_with_windows_8_1() {
		withOsName("Windows 8.1", new Runnable() {
				@Override
				public void run() {
					assertThat(evaluate()).isTrue();
				}
			}
		);
	}

	@Test
	public void it_should_return_true_with_windows_8() {
		withOsName("Windows 8", new Runnable() {
				@Override
				public void run() {
					assertThat(evaluate()).isTrue();
				}
			}
		);
	}

	@Test
	public void it_should_return_true_with_windows_7() {
		withOsName("Windows 7", new Runnable() {
				@Override
				public void run() {
					assertThat(evaluate()).isTrue();
				}
			}
		);
	}

	@Test
	public void it_should_return_true_with_windows_server_2022() {
		withOsName("Windows Server 2022", new Runnable() {
				@Override
				public void run() {
					assertThat(evaluate()).isTrue();
				}
			}
		);
	}

	@Test
	public void it_should_return_true_with_windows_server_2019() {
		withOsName("Windows Server 2019", new Runnable() {
				@Override
				public void run() {
					assertThat(evaluate()).isTrue();
				}
			}
		);
	}

	@Test
	public void it_should_return_false_with_macos() {
		withOsName("macOS", new Runnable() {
				@Override
				public void run() {
					assertThat(evaluate()).isFalse();
				}
			}
		);
	}

	@Test
	public void it_should_return_false_with_macosx() {
		withOsName("Mac OS X", new Runnable() {
				@Override
				public void run() {
					assertThat(evaluate()).isFalse();
				}
			}
		);
	}

	@Test
	public void it_should_return_false_with_linux() {
		withOsName("Linux", new Runnable() {
				@Override
				public void run() {
					assertThat(evaluate()).isFalse();
				}
			}
		);
	}

	private static boolean evaluate() {
		return new IsWindowsCondition().apply();
	}
}
