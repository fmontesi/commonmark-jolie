# commonmark-jolie
A Jolie library for rendering markdown adhering to the commonmark specification, based on commonmark-java.

# Installation

If you have JPM installed:

```
jpm install @jolie/commonmark
```

If you do not have JPM installed:

```
npx @jolie/jpm install @jolie/commonmark
```

# Usage

```jolie
from @jolie.commonmark import CommonMark

service Main {
  embed CommonMark as commonMark
  
  main {
    render@commonMark( "# Hello!" )( html ) // html == "<h1>Hello!</h1>"
  }
}
```
