from ..main import CommonMark
from console import Console
from assertions import Assertions

interface TestIface {
RequestResponse:
	///@Test
	p(void)(void) throws AssertionError(string),

	///@Test
	h1(void)(void) throws AssertionError(string)
}

service Main {
	inputPort Input {
		location: "local"
		interfaces: TestIface
	}

	embed CommonMark as commonMark
	embed Console as console
	embed Assertions as assertions

	main {
		p()() {
			render@commonMark( "Hello" )( response )
			equals@assertions( {
				actual = response
				expected = "<p>Hello</p>\n"
			} )()
		}

		h1()() {
			render@commonMark( "# Hello" )( response )
			equals@assertions( {
				actual = response
				expected = "<h1>Hello</h1>\n"
			} )()
		}
	}
}