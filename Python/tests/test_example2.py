import pytest

def test_check_string():
    assert "Hi" == "Hi"

# The @ symbol denotes the marker and we can run the function which are marked in the marker
@pytest.mark.great
def test_greater_equal():
    assert 20>=2

def test_lesser_equal():
    assert 9<=19