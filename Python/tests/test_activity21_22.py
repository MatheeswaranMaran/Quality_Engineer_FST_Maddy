import pytest


@pytest.mark.activities
def test_sum():
    x = 3
    y = 4
    assert x + y == 7


@pytest.mark.activities
def test_diff():
    x = 3
    y = 4
    assert y - x == 1


@pytest.mark.activities
def test_product():
    x = 3
    y = 4
    assert x * y == 12


@pytest.mark.activities
def test_quotient():
    x = 2
    y = 4
    assert y / x == 2
