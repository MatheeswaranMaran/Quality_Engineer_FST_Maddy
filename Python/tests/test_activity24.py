import pytest


@pytest.fixture
def wallet():
    return 0


@pytest.mark.parametrize("earned, spent, expected", [(30, 10, 20), (20, 2, 18)])
def test_expense(wallet, earned, spent, expected):

    amount = wallet

    amount += earned

    amount -= spent
    assert amount == expected
