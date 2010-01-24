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

wings.dnd.columnSelector = '.column';
wings.dnd.gadgetSelector = '.gadgets-gadget-chrome';
wings.dnd.handleSelector = '.gadgets-gadget-title-bar';
wings.dnd.contentSelector = '.gadgets-gadget-content';
wings.dnd.gadgetPlaceHolder = 'gadget-placeholder'; //sortable's placeholder attribute expects class name without '.' prefix.
wings.dnd.overlay	= 'gadgets-dnd-overlay'; //do not prefix clas name with dot
wings.dnd.$gadgetMasks = null;

wings.dnd.init = function() {
	var $dragableGadgets = $(this.gadgetSelector, this.columnSelector);

	//create overlays
	$dragableGadgets.each(function(i) {
		$("<div>").addClass(wings.dnd.overlay).css({
						"height":$(this).height(),
						"width":$(this).width()
		}).prependTo(this);
	}); 

	//change cursor pointer
	$dragableGadgets.find(this.handleSelector).css({
		'cursor':'move'
	}).mousedown(function (e) {
		var $gadgetBeingDragged = $(e.target).parent();
		$gadgetBeingDragged.css({width: $gadgetBeingDragged.width() + 'px'});
	}).mouseup(function (e) {
		var $gadgetBeingDragged = $(e.target).parent();
		$gadgetBeingDragged.css('width','');
	});

	var $columns = $(this.columnSelector);
	
	//find all gadget masks
	this.$gadgetMasks = $dragableGadgets.find("." + wings.dnd.overlay);

	//initialize dnd
	$columns.sortable({
		items: $dragableGadgets,				// set gadgets on a page as draggable items
		connectWith: $columns,		// Connect each column with every other column
		handle: this.handleSelector,			// Set gadget's titlebar as dnd handle 
		placeholder: this.gadgetPlaceHolder,	// Gadget placeholder class
		forcePlaceholderSize: true,
		revert: 50,								// Animation speed
		delay: 10,								// Delay before action
		containment: 'document'					// Set document as containment for dnd
	});

	$columns.bind('sortstart', function(event, ui) {
		wings.dnd.$gadgetMasks.css("display","block");
	});

	$columns.bind('sortstop', function(event, ui) {	
		wings.dnd.$gadgetMasks.css("display","none");
	});
};