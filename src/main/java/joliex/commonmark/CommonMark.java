/*
 * Copyright (C) 2023 Fabrizio Montesi <famontesi@gmail.com>
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301  USA
 */

package joliex.commonmark;

import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;

import jolie.runtime.AndJarDeps;
import jolie.runtime.JavaService;
import jolie.runtime.embedding.RequestResponse;

@AndJarDeps( "commonmark-0.21.0.jar" )
public class CommonMark extends JavaService {
	@RequestResponse
	public String render( String request ) {
		var parser = Parser.builder().build();
		var node = parser.parse( request );
		var renderer = HtmlRenderer.builder().build();
		return renderer.render( node );
	}
}
