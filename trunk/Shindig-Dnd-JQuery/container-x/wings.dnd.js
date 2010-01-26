/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

var wings = wings || {};

wings.dnd = wings.dnd || {};

wings.dnd.COLUMN_SELECTOR = '.column';
wings.dnd.GADGET_SELECTOR = '.gadgets-gadget-chrome';
wings.dnd.HANDLE_SELECTOR = '.gadgets-gadget-title-bar';
wings.dnd.CONTENT_SELECTOR = '.gadgets-gadget-content';
wings.dnd.GADGET_PLACEHOLDER = 'gadget-placeholder'; //sortable's placeholder attribute expects class name without '.' prefix.
wings.dnd.OVERLAY	= 'gadgets-dnd-overlay'; //do not prefix clas name with dot
wings.dnd.$gadgetMasks = null;

wings.dnd.init = function() {
	var $dragableGadgets = $(this.GADGET_SELECTOR, this.COLUMN_SELECTOR);

	//create overlays
	$dragableGadgets.each(function(i) {
		$("<div>").addClass(wings.dnd.OVERLAY).css({
						"height":$(this).height(),
						"width":$(this).width()
		}).prependTo(this);
	}); 

	//change cursor pointer
	$dragableGadgets.find(this.HANDLE_SELECTOR).css('cursor','move');

	var $columns = $(this.COLUMN_SELECTOR);
	
	//find all gadget masks
	this.$gadgetMasks = $dragableGadgets.find("." + this.OVERLAY);

	//initialize dnd
	$columns.sortable({
		items: $dragableGadgets,				// set gadgets on a page as draggable items
		connectWith: this.COLUMN_SELECTOR,		// Connect each column with every other column
		handle: this.HANDLE_SELECTOR,			// Set gadget's titlebar as dnd handle 
		placeholder: this.GADGET_PLACEHOLDER,	// Gadget placeholder class
		forcePlaceholderSize: true,
		cursor: 'move',							// keep the cursor to 'move' during drag operation
		revert: 50,								// Animation speed
		delay: 10,								// Delay before action
		containment: 'document',					// Set document as containment for dnd
		start: function(e, ui) {
					wings.dnd.$gadgetMasks.css("display","block");
					var $gadgetBeingDragged = $(ui.helper);
					var $gadgetPlaceHolder = $(ui.placeholder);
					$gadgetPlaceHolder.css({width:$gadgetBeingDragged.width(),height:$gadgetBeingDragged.height()});
		},
		stop: function(e, ui) {wings.dnd.$gadgetMasks.css("display","none");}
	});
};