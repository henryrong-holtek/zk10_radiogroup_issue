zk.afterLoad("zul.wgt", function () {
    var _xRadiogroup = {};
    zk.override(zul.wgt.Radiogroup.prototype, _xRadiogroup, {
    	_fixOnAdd : function(t) {
	        this._jsel >= 0 && t.isSelected() ? t.setSelected(!1) : this._fixSelectedIndex(),
            t.setDisabled(this.isDisabled() || t.isDisabled()) //rg disabled || radio disabled == radio disabled, radio enabled only if both Rg and Radio are not disabled
        }
	});
});