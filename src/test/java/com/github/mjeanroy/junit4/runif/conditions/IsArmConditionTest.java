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

import static com.github.mjeanroy.junit4.runif.conditions.JavaTestingUtils.withOsArch;
import static org.assertj.core.api.Assertions.assertThat;

public class IsArmConditionTest {

	@Test
	public void it_should_return_true_with_aarch64() {
		withOsArch("aarch64", new Runnable() {
				@Override
				public void run() {
					assertThat(evaluate()).isTrue();
				}
			}
		);
	}

	@Test
	public void it_should_return_true_with_arm64() {
		withOsArch("arm64", new Runnable() {
				@Override
				public void run() {
					assertThat(evaluate()).isTrue();
				}
			}
		);
	}

	@Test
	public void it_should_return_true_with_arm() {
		withOsArch("arm", new Runnable() {
				@Override
				public void run() {
					assertThat(evaluate()).isTrue();
				}
			}
		);
	}

	@Test
	public void it_should_return_true_with_arm32() {
		withOsArch("arm32", new Runnable() {
				@Override
				public void run() {
					assertThat(evaluate()).isTrue();
				}
			}
		);
	}

	@Test
	public void it_should_return_false_with_x86() {
		withOsArch("x86", new Runnable() {
				@Override
				public void run() {
					assertThat(evaluate()).isFalse();
				}
			}
		);
	}

	@Test
	public void it_should_return_false_with_x86_64() {
		withOsArch("x86_64", new Runnable() {
				@Override
				public void run() {
					assertThat(evaluate()).isFalse();
				}
			}
		);
	}

	@Test
	public void it_should_return_false_with_amd64() {
		withOsArch("amd64", new Runnable() {
				@Override
				public void run() {
					assertThat(evaluate()).isFalse();
				}
			}
		);
	}

	@Test
	public void it_should_return_false_with_i386() {
		withOsArch("i386", new Runnable() {
				@Override
				public void run() {
					assertThat(evaluate()).isFalse();
				}
			}
		);
	}

	@Test
	public void it_should_return_false_with_i486() {
		withOsArch("i486", new Runnable() {
				@Override
				public void run() {
					assertThat(evaluate()).isFalse();
				}
			}
		);
	}

	@Test
	public void it_should_return_false_with_i586() {
		withOsArch("i586", new Runnable() {
				@Override
				public void run() {
					assertThat(evaluate()).isFalse();
				}
			}
		);
	}

	@Test
	public void it_should_return_false_with_i686() {
		withOsArch("i686", new Runnable() {
				@Override
				public void run() {
					assertThat(evaluate()).isFalse();
				}
			}
		);
	}

	private static boolean evaluate() {
		return new IsArmCondition().apply();
	}
}
