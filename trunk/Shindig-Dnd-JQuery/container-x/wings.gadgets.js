/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */

var wings = wings || {};

wings.gadgets = wings.gadgets || {};

/**
 * Define wings' Gadget class that inherits IfrGadget defined in Shindig's gadgets.js
 */
wings.gadgets.Gadget = function(opt_params) {
  gadgets.IfrGadget.call(this, opt_params);
  this.serverBase_ = 'http://modules.partuza.nl/gadgets/' // default gadget server
};

wings.gadgets.Gadget.inherits(gadgets.IfrGadget);

//override and extend core gadget functionality
wings.gadgets.Gadget.prototype.getTitleBarContent = function(continuation) {
  var settingsButton = this.hasViewablePrefs_() ?
      '<a href="#" onclick="gadgets.container.getGadget(' + this.id +
          ').handleOpenUserPrefsDialog();return false;" class="' + this.cssClassTitleButton +
          '">settings</a> '
      : '';
  continuation('<div id="' + this.cssClassTitleBar + '-' + this.id +
      '" class="' + this.cssClassTitleBar + '"><span id="' +
      this.getIframeId() + '_title" class="' +
      this.cssClassTitle + '">' + (this.title ? this.title : 'No Title') + '</span><span class="' +
      this.cssClassTitleButtonBar + '">' + settingsButton +
      '<a href="#" onclick="gadgets.container.getGadget(' + this.id +
      ').handleToggle();return false;" class="' + this.cssClassTitleButton +
      '">toggle</a></span></div>');
};


//Set Wings' Gadget class as default container's gadgetClass
gadgets.IfrContainer.prototype.gadgetClass = wings.gadgets.Gadget;