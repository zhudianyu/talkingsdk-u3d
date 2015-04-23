package com.talkingsdk.models;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import org.json.JSONException;

public class PayData {
	private String _myOrderId = "";
	private String _productId = "";
	private String _productName = "";
	// 成交价格 以分为单位
	private int  _productRealPrice = 0;
	// 原价 以分为单位
	private int  _productIdealPrice = 0;
	private int    _productCount = 0;
	private String _description =  "";
	private String _submitTime = "";
	private Map<String,String> _ex = new HashMap<String,String>();

	public String getSubmitTime() {
		return _submitTime;
	}
	public void setSubmitTime(String submitTime) {
		this._submitTime = submitTime;
	}

	public String getMyOrderId() {
		return _myOrderId;
	}
	public void setMyOrderId(String myOrderId) {
		this._myOrderId = myOrderId;
	}
	public String getProductId() {
		return _productId;
	}
	public void setProductId(String productId) {
		this._productId = productId;
	}
	public String getProductName() {
		return _productName;
	}
	public void setProductName(String productName) {
		this._productName = productName;
	}
	public int getProductRealPrice() {
		return _productRealPrice;
	}
	public void setProductRealPrice(int productRealPrice) {
		this._productRealPrice = productRealPrice;
	}
	public int getProductIdealPrice() {
		return _productIdealPrice;
	}
	public void setProductIdealPrice(int productIdealPrice) {
		this._productIdealPrice = productIdealPrice;
	}
	public int getProductCount() {
		return _productCount;
	}
	public void setProductCount(int productCount) {
		this._productCount = productCount;
	}
	public String getDescription() {
		return _description;
	}
	public void setDescription(String description) {
		this._description = description;
	}

	public void setEx(HashMap<String,String> ex) {
		this._ex = ex;
	}

	public Map<String,String> getEx() {
		return _ex;
	}

	@Override
    public String toString() {
        return "PayData [_myOrderId=" + _myOrderId + ", _productId=" + _productId + ", _productName=" + _productName
                + ", _productRealPrice=" + String.valueOf(_productRealPrice) + ", _productIdealPrice=" + String.valueOf(_productIdealPrice)
                + ", _productCount=" + String.valueOf(_productCount) + ",_description="+_description + "]";
    }

    public String toJSON() {
        String jsonStr = null;
        try {
            JSONObject json = new JSONObject();
            json.put("MyOrderId", this._myOrderId == null ? "": this._myOrderId );
            json.put("ProductId", this._productId == null ? "": this._productId );
            json.put("ProductName", this._productName == null ? "": this._productName );
            json.put("ProductRealPrice", this._productRealPrice );
            json.put("ProductIdealPrice", this._productIdealPrice);
            json.put("ProductCount", this._productCount);
            json.put("Description", this._description == null ? "": this._description );
            json.put("SubmitTime", this._submitTime == null ? "": this._submitTime );

            JSONObject ext = new JSONObject(this._ex);
            json.put("Ext", ext);
            jsonStr = json.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonStr;
    }

}
