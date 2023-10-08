package task2

class PositiveNegativeCountTest extends org.scalatest.funsuite.AnyFunSuiteLike {

  test("common cases") {
    assert(PositiveNegativeCount.count(List(0, 0, 1, 0, 0, 1, 0, 1)) == 0)
    assert(PositiveNegativeCount.count(List(1, 0, -1)) == 1)
    assert(PositiveNegativeCount.count(List(1, 0, -1, 0, 0, 0, -1)) == 1)
    assert(PositiveNegativeCount.count(List(1, -2, 3, 3, 4, -2, -2, -3, 1)) == 4)
  }

  test("corner cases") {
    assert(PositiveNegativeCount.count(List()) == 0)
    assert(PositiveNegativeCount.count(List(0)) == 0)
    assert(PositiveNegativeCount.count(List(0, 0, 0)) == 0)
    assert(PositiveNegativeCount.count(List(0, 0, 0, 1)) == 0)
    assert(PositiveNegativeCount.count(List(0, 0, 0, -1)) == 0)
    assert(PositiveNegativeCount.count(List(0, 0, 0, 1, 0)) == 0)
    assert(PositiveNegativeCount.count(List(0, 0, 0, -1, 0)) == 0)
    assert(PositiveNegativeCount.count(List(1, 0, 0, 0)) == 0)
    assert(PositiveNegativeCount.count(List(-1, 0, 0, 0)) == 0)
    assert(PositiveNegativeCount.count(List(1, 0, 0, 0, -1)) == 1)
    assert(PositiveNegativeCount.count(List(-1, 0, 0, 0, 1)) == 1)
    assert(PositiveNegativeCount.count(List(Int.MaxValue, 1)) == 0)
    assert(PositiveNegativeCount.count(List(Int.MaxValue, -1)) == 1)
    assert(PositiveNegativeCount.count(List(Int.MinValue, 1)) == 1)
    assert(PositiveNegativeCount.count(List(Int.MinValue, -1)) == 0)
    assert(PositiveNegativeCount.count(List(1, Int.MaxValue)) == 0)
    assert(PositiveNegativeCount.count(List(-1, Int.MaxValue)) == 1)
    assert(PositiveNegativeCount.count(List(1, Int.MinValue)) == 1)
    assert(PositiveNegativeCount.count(List(-1, Int.MinValue)) == 0)
  }

}
