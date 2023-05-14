interface CommonMarkIface {
RequestResponse: render(string)(string)
}

service CommonMark {
	inputPort Input {
		location: "local"
		interfaces: CommonMarkIface
	}
	foreign java {
		class: "joliex.commonmark.CommonMark"
	}
}