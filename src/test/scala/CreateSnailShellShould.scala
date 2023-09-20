import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper

class CreateSnailShellShould extends AnyFunSuite {

  test("generate empty array for N = 0") {
    Main.createSnailShell(0) shouldBe Array()
  }

  test("generate empty array for N negative") {
    Main.createSnailShell(-10) shouldBe Array()
  }

  test("generate single element matrix for N = 1") {
    Main.createSnailShell(1) shouldBe Array(Array(1))
  }

  test("generate proper matrix for N = 2") {
    Main.createSnailShell(2) shouldBe
      Array(
        Array(1, 2),
        Array(4, 3)
      )
  }

  test("generate proper matrix for N = 3") {
    Main.createSnailShell(3) shouldBe
      Array(
        Array(1, 2, 3),
        Array(8, 9, 4),
        Array(7, 6, 5)
      )
  }

  test("generate proper matrix for N = 4") {
    Main.createSnailShell(4) shouldBe
      Array(
        Array(1,  2,  3,  4),
        Array(12, 13, 14, 5),
        Array(11, 16, 15, 6),
        Array(10, 9,  8,  7)
      )
  }

  test("generate proper matrix for N = 5") {
    Main.createSnailShell(5) shouldBe
      Array(
        Array(1,  2,  3,  4,  5),
        Array(16, 17, 18, 19, 6),
        Array(15, 24, 25, 20, 7),
        Array(14, 23, 22, 21, 8),
        Array(13, 12, 11, 10, 9)
      )
  }

}
