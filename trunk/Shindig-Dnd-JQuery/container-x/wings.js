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

// This container lays out and renders gadgets itself.
wings.renderGadgets = function() {
  var $gadgetChromes = $('.gadgets-gadget-chrome','.column');
  var _gadgets = [];
  var _gadgetChromeIds = [];

  $gadgetChromes.each(function(i) {
	var $this = $(this);
	var specUrl = $this.attr('spec');
	_gadgets[_gadgets.length] = gadgets.container.createGadget({specUrl: specUrl}),
	_gadgetChromeIds[_gadgetChromeIds.length] = this.id;
	gadgets.container.addGadget(_gadgets[_gadgets.length - 1]);
  });

  gadgets.container.layoutManager.setGadgetChromeIds(_gadgetChromeIds);

  $(_gadgets).each(function(i) {
	  gadgets.container.renderGadget(this);
  });
};

$(document).ready(function() {
	wings.renderGadgets();
	wings.dnd.init();
});