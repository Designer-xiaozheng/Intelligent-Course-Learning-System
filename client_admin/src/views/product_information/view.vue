<template>
	<el-main class="bg edit_wrap">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">

							<el-col v-if="user_group === '管理员' || $check_field('get','supplier_no') || $check_field('add','supplier_no') || $check_field('set','supplier_no')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="供应商编号" prop="supplier_no">
																		<div v-if="user_group !== '管理员'">
							{{ get_user_session_supplier_no(form['supplier_no']) }}
							<!--<el-input id="business_name" v-model="form['supplier_no']" placeholder="请输入供应商编号"-->
							<!--v-if="user_group === '管理员' || (form['product_information_id'] && $check_field('set','supplier_no')) || (!form['product_information_id'] && $check_field('add','supplier_no'))" :disabled="disabledObj['supplier_no_isDisabled']"></el-input>-->
							<!--<div v-else-if="$check_field('get','supplier_no')">{{form['supplier_no']}}</div>-->
							<el-select v-if="user_group === '管理员' || (form['product_information_id'] && $check_field('set','supplier_no')) || (!form['product_information_id'] && $check_field('add','supplier_no'))" id="supplier_no" v-model="form['supplier_no']" :disabled="disabledObj['supplier_no_isDisabled']">
								<el-option v-for="o in list_user_supplier_no" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
										   :value="o['user_id']">
								</el-option>
							</el-select>
							<el-select v-else-if="$check_field('get','supplier_no')" id="supplier_no" v-model="form['supplier_no']" :disabled="true">
								<el-option v-for="o in list_user_supplier_no" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
										   :value="o['user_id']">
								</el-option>
							</el-select>
						</div>
						<el-select v-else id="supplier_no" v-model="form['supplier_no']" :disabled="disabledObj['supplier_no_isDisabled']">
							<el-option v-for="o in list_user_supplier_no" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
									   :value="o['user_id']">
							</el-option>
						</el-select>
																</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','article_no') || $check_field('add','article_no') || $check_field('set','article_no')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="商品编号" prop="article_no">
												<el-input id="article_no" v-model="form['article_no']" placeholder="请输入商品编号"
							  v-if="user_group === '管理员' || (form['product_information_id'] && $check_field('set','article_no')) || (!form['product_information_id'] && $check_field('add','article_no'))" :disabled="true"></el-input>
					<div v-else-if="$check_field('get','article_no')">{{form['article_no']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','trade_name') || $check_field('add','trade_name') || $check_field('set','trade_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="商品名称" prop="trade_name">
												<el-input id="trade_name" v-model="form['trade_name']" placeholder="请输入商品名称"
							  v-if="user_group === '管理员' || (form['product_information_id'] && $check_field('set','trade_name')) || (!form['product_information_id'] && $check_field('add','trade_name'))" :disabled="disabledObj['trade_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','trade_name')">{{form['trade_name']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','commodity_type') || $check_field('add','commodity_type') || $check_field('set','commodity_type')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="商品类型" prop="commodity_type">
								<el-select id="commodity_type" v-model="form['commodity_type']"
						v-if="user_group === '管理员' || (form['product_information_id'] && $check_field('set','commodity_type')) || (!form['product_information_id'] && $check_field('add','commodity_type'))">
						<el-option v-for="o in list_commodity_type" :key="o['product_type']" :label="o['product_type']"
							:value="o['product_type']">
						</el-option>
					</el-select>
					<div v-else-if="$check_field('get','commodity_type')">{{form['commodity_type']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','picture') || $check_field('add','picture') || $check_field('set','picture')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="图片" prop="picture">
								<el-upload :disabled="disabledObj['picture_isDisabled']" id="picture" class="avatar-uploader" drag
						accept="image/gif, image/jpeg, image/png, image/jpg" action="" :http-request="upload_picture"
						:show-file-list="false" v-if="user_group === '管理员' || (form['product_information_id'] && $check_field('set','picture')) || (!form['product_information_id'] && $check_field('add','picture'))">
						<img v-if="form['picture']" :src="$fullUrl(form['picture'])" class="avatar">
						<i v-else class="el-icon-plus avatar-uploader-icon"></i>
					</el-upload>
					<el-image v-else-if="$check_field('get','picture')" style="width: 100px; height: 100px"
						:src="$fullUrl(form['picture'])" :preview-src-list="[$fullUrl(form['picture'])]">
						<div slot="error" class="image-slot">
							<img src="../../../public/img/error.png" style="width: 90px; height: 90px" />
						</div>
					</el-image>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','brand') || $check_field('add','brand') || $check_field('set','brand')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="品牌" prop="brand">
												<el-input id="brand" v-model="form['brand']" placeholder="请输入品牌"
							  v-if="user_group === '管理员' || (form['product_information_id'] && $check_field('set','brand')) || (!form['product_information_id'] && $check_field('add','brand'))" :disabled="disabledObj['brand_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','brand')">{{form['brand']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','specifications') || $check_field('add','specifications') || $check_field('set','specifications')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="规格" prop="specifications">
												<el-input id="specifications" v-model="form['specifications']" placeholder="请输入规格"
							  v-if="user_group === '管理员' || (form['product_information_id'] && $check_field('set','specifications')) || (!form['product_information_id'] && $check_field('add','specifications'))" :disabled="disabledObj['specifications_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','specifications')">{{form['specifications']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','stock') || $check_field('add','stock') || $check_field('set','stock')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="库存" prop="stock">
								<el-input-number id="stock" v-model.number="form['stock']"
						v-if="user_group === '管理员' || (form['product_information_id'] && $check_field('set','stock')) || (!form['product_information_id'] && $check_field('add','stock'))" :disabled="disabledObj['stock_isDisabled']"></el-input-number>
					<div v-else-if="$check_field('get','stock')">{{form['stock']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','price') || $check_field('add','price') || $check_field('set','price')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="价格" prop="price">
								<el-input-number id="price" v-model.number="form['price']"
						v-if="user_group === '管理员' || (form['product_information_id'] && $check_field('set','price')) || (!form['product_information_id'] && $check_field('add','price'))" :disabled="disabledObj['price_isDisabled']"></el-input-number>
					<div v-else-if="$check_field('get','price')">{{form['price']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','details') || $check_field('add','details') || $check_field('set','details')" :xs="24" :sm="24" :lg="24" class="el_form_editor_warp">
				<el-form-item label="详情" prop="details">
					<quill-editor v-model.number="form['details']"
						v-if="user_group === '管理员' || (form['product_information_id'] && $check_field('set','details')) || (!form['product_information_id'] && $check_field('add','details')) ">
					</quill-editor>
					<div v-else-if="$check_field('get','details')" v-html="form['details']"></div>
				</el-form-item>
			</el-col>
					
	
	
	
	
	
	
			<el-col :xs="24" :sm="12" :lg="8" class="el_form_btn_warp">
				<el-form-item>
					<el-button type="primary" @click="submit()">提交</el-button>
					<el-button @click="cancel()">取消</el-button>
				</el-form-item>
			</el-col>

		</el-form>
	</el-main>
</template>

<script>
	import mixin from "@/mixins/page.js";

	export default {
		mixins: [mixin],
		data() {
			return {
				field: "product_information_id",
				url_add: "~/api/product_information/add?",
				url_set: "~/api/product_information/set?",
				url_get_obj: "~/api/product_information/get_obj?",
				url_upload: "~/api/product_information/upload?",

				query: {
					"product_information_id": 0,
				},

				form: {
								"supplier_no": 0, // 供应商编号
										"article_no": this.$get_stamp(), // 商品编号
										"trade_name":  '', // 商品名称
										"commodity_type":  '', // 商品类型
										"picture":  '', // 图片
										"brand":  '', // 品牌
										"specifications":  '', // 规格
										"stock":  0, // 库存
										"price":  0, // 价格
										"details":  '', // 详情
											"product_information_id": 0, // ID
						
				},
				disabledObj:{
								"supplier_no_isDisabled": false,
										"article_no_isDisabled": false,
										"trade_name_isDisabled": false,
										"commodity_type_isDisabled": false,
										"picture_isDisabled": false,
										"brand_isDisabled": false,
										"specifications_isDisabled": false,
					          			"stock_isDisabled": false,
					          			"price_isDisabled": false,
										"details_isDisabled": false,
										},

	
					// 用户列表
				list_user_supplier_no: [],
						// 用户组
				group_user_supplier_no: "",
				
		
						// 商品类型选项列表
				list_commodity_type: [""],
	
		
		
		
		
		
		
	
			}
		},
		methods: {


	
	
				/**
			 * 获取供应商用户列表
			 */
			async get_list_user_supplier_no() {
                // if(this.user_group !== "管理员" && this.form["supplier_no"] === 0) {
                //     this.form["supplier_no"] = this.user.user_id;
                // }
                var json = await this.$get("~/api/user/get_list?user_group=供应商");
                if(json.result && json.result.list){
                    this.list_user_supplier_no = json.result.list;
                }
                else if(json.error){
                    console.error(json.error);
                }
			},
					/**
			 * 获取供应商用户组
			 */
			async get_group_user_supplier_no() {
							this.form["supplier_no"] = this.user.user_id;
							var json = await this.$get("~/api/user_group/get_obj?name=供应商");
				if(json.result && json.result.obj){
					this.group_user_supplier_no = json.result.obj;
				}
				else if(json.error){
					console.error(json.error);
				}
			},
			get_user_session_supplier_no(id){
				var _this = this;
				var user_id = {"user_id":id}
				var url = "~/api/"+_this.group_user_supplier_no.source_table+"/get_obj?"
				this.$get(url, user_id, function(res) {
					if (res.result && res.result.obj) {
						var arr = []
						for (let key in res.result.obj) {
							arr.push(key)
						}
						var arrForm = []
									for (let key in _this.form) {
							arrForm.push(key)
						}
												_this.form["supplier_no"] = id
									_this.disabledObj['supplier_no' + '_isDisabled'] = true
						for (var i=0;i<arr.length;i++){
						  if (arr[i]!=='examine_state' && arr[i]!=='examine_reply') {
							for (var j = 0; j < arrForm.length; j++) {
							  if (arr[i] === arrForm[j]) {
								if (arr[i] !== "supplier_no") {
			                      _this.form[arrForm[j]] = res.result.obj[arr[i]]
			                      _this.disabledObj[arrForm[j] + '_isDisabled'] = true
								  break;
								} else {
								  _this.disabledObj[arrForm[j] + '_isDisabled'] = true
								}
							  }
							}
						  }
						}
					}
				});
			},
					get_user_supplier_no(id){
				var obj = this.list_user_supplier_no.getObj({"user_id":id});
				var ret = "";
				if(obj){
					if(obj.nickname){
						ret = obj.nickname;}
					else{
						ret = obj.username;
					}
				}
				return ret;
			},
			
	
			
	
			
				/**
			 * 获取商品类型列表
			 */
			async get_list_commodity_type() {
				var json = await this.$get("~/api/commodity_classification/get_list?");
				if(json.result && json.result.list){
					this.list_commodity_type = json.result.list;
				}
				else if(json.error){
					console.error(json.error);
				}
			},
	
						/**
			 * 上传图片
			 * @param {Object} param 图片参数
			 */
			upload_picture(param){
						this.uploadFile(param.file, "picture");
					},
	
	
			
	
			
	
			
	
			
	
			
	
		
			/**
			 * 获取对象之前
			 * @param {Object} param
			 */
			get_obj_before(param) {
				var form = "";
																																	
				if(this.form && form){
					Object.keys(this.form).forEach(key => {
						Object.keys(form).forEach(dbKey => {
							// if(dbKey === "charging_standard"){
							// 	this.form['charging_rules'] = form[dbKey];
							// 	this.disabledObj['charging_rules_isDisabled'] = true;
							// };
							if(key === dbKey){
								this.disabledObj[key+'_isDisabled'] = true;
							}
						})
					})
				}
																								$.db.del("form");
				return param;
			},

			/**
			 * 获取对象之后
			 * @param {Object} json
			 * @param {Object} func
			 */
			get_obj_after(json, func){


																														

			},

			/**
			 * 提交前验证事件
			 * @param {Object} 请求参数
			 * @return {String} 验证成功返回null, 失败返回错误提示
			 */
			submit_check(param) {
				let msg = null
																																				return msg;
			},

			is_view(){
				var bl = this.user_group == "管理员";

				if(!bl){
					bl = this.$check_action('/product_information/table','add');
					console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
				}
				if(!bl){
					bl = this.$check_action('/product_information/table','set');
					console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
				}
				if(!bl){
					bl = this.$check_action('/product_information/view','add');
					console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
				}
				if(!bl){
					bl = this.$check_action('/product_information/view','set');
					console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
				}
				if(!bl){
					bl = this.$check_action('/product_information/view','get');
					console.log(bl ? "你有视图查询权限视作有查询权限" : "你没有视图查询权限");
				}

				console.log(bl ? "具有当前页面的查看权，请注意这不代表你有字段的查看权" : "无权查看当前页，请注意即便有字段查询权限没有页面查询权限也不行");

				return bl;
			},
			/**
			 * 上传文件
			 * @param {Object} param
			 */
			uploadimg(param) {
				this.uploadFile(param.file, "avatar");
			},

		},
		created() {
					this.get_list_user_supplier_no();
					this.get_group_user_supplier_no();
											this.get_list_commodity_type();
																},
	}
</script>

<style>
	.avatar-uploader .el-upload {
		border: 1px dashed #d9d9d9;
		border-radius: 6px;
		cursor: pointer;
		position: relative;
		overflow: hidden;
	}

	.avatar-uploader .el-upload:hover {
		border-color: #409EFF;
	}

	.avatar-uploader-icon {
		font-size: 28px;
		color: #8c939d;
		width: 178px;
		height: 178px;
		line-height: 178px;
		text-align: center;
	}

	.avatar {
		width: 178px;
		height: 178px;
		display: block;
	}




</style>
