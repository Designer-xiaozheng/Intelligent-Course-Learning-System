<template>
	<el-main class="bg edit_wrap">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">

							<el-col v-if="user_group === '管理员' || $check_field('get','supplier_no') || $check_field('add','supplier_no') || $check_field('set','supplier_no')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="供应商编号" prop="supplier_no">
													<el-select v-if="user_group === '管理员' || (form['order_signing_id'] && $check_field('set','supplier_no')) || (!form['order_signing_id'] && $check_field('add','supplier_no'))" id="supplier_no" v-model="form['supplier_no']" :disabled="disabledObj['supplier_no_isDisabled']">
							<el-option v-for="o in list_user_supplier_no" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
									   :value="o['user_id']">
							</el-option>
						</el-select>
						<el-select v-else-if="$check_field('get','supplier_no')" id="supplier_no" v-model="form['supplier_no']" :disabled="true">
							<el-option v-for="o in list_user_supplier_no" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
									   :value="o['user_id']">
							</el-option>
						</el-select>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','order_number') || $check_field('add','order_number') || $check_field('set','order_number')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="订单号" prop="order_number">
												<el-input id="order_number" v-model="form['order_number']" placeholder="请输入订单号"
							  v-if="user_group === '管理员' || (form['order_signing_id'] && $check_field('set','order_number')) || (!form['order_signing_id'] && $check_field('add','order_number'))" :disabled="disabledObj['order_number_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','order_number')">{{form['order_number']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','user') || $check_field('add','user') || $check_field('set','user')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="用户" prop="user">
													<el-select v-if="user_group === '管理员' || (form['order_signing_id'] && $check_field('set','user')) || (!form['order_signing_id'] && $check_field('add','user'))" id="user" v-model="form['user']" :disabled="disabledObj['user_isDisabled']">
							<el-option v-for="o in list_user_user" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
									   :value="o['user_id']">
							</el-option>
						</el-select>
						<el-select v-else-if="$check_field('get','user')" id="user" v-model="form['user']" :disabled="true">
							<el-option v-for="o in list_user_user" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
									   :value="o['user_id']">
							</el-option>
						</el-select>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','trade_name') || $check_field('add','trade_name') || $check_field('set','trade_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="商品名称" prop="trade_name">
												<el-input id="trade_name" v-model="form['trade_name']" placeholder="请输入商品名称"
							  v-if="user_group === '管理员' || (form['order_signing_id'] && $check_field('set','trade_name')) || (!form['order_signing_id'] && $check_field('add','trade_name'))" :disabled="disabledObj['trade_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','trade_name')">{{form['trade_name']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','purchase_quantity') || $check_field('add','purchase_quantity') || $check_field('set','purchase_quantity')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="购买数量" prop="purchase_quantity">
												<el-input id="purchase_quantity" v-model="form['purchase_quantity']" placeholder="请输入购买数量"
							  v-if="user_group === '管理员' || (form['order_signing_id'] && $check_field('set','purchase_quantity')) || (!form['order_signing_id'] && $check_field('add','purchase_quantity'))" :disabled="disabledObj['purchase_quantity_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','purchase_quantity')">{{form['purchase_quantity']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','consignee_name') || $check_field('add','consignee_name') || $check_field('set','consignee_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="收货人姓名" prop="consignee_name">
												<el-input id="consignee_name" v-model="form['consignee_name']" placeholder="请输入收货人姓名"
							  v-if="user_group === '管理员' || (form['order_signing_id'] && $check_field('set','consignee_name')) || (!form['order_signing_id'] && $check_field('add','consignee_name'))" :disabled="disabledObj['consignee_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','consignee_name')">{{form['consignee_name']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','contact_number') || $check_field('add','contact_number') || $check_field('set','contact_number')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="联系电话" prop="contact_number">
												<el-input id="contact_number" v-model="form['contact_number']" placeholder="请输入联系电话"
							  v-if="user_group === '管理员' || (form['order_signing_id'] && $check_field('set','contact_number')) || (!form['order_signing_id'] && $check_field('add','contact_number'))" :disabled="disabledObj['contact_number_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','contact_number')">{{form['contact_number']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','receive_room_number') || $check_field('add','receive_room_number') || $check_field('set','receive_room_number')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="收房间号" prop="receive_room_number">
												<el-input id="receive_room_number" v-model="form['receive_room_number']" placeholder="请输入收房间号"
							  v-if="user_group === '管理员' || (form['order_signing_id'] && $check_field('set','receive_room_number')) || (!form['order_signing_id'] && $check_field('add','receive_room_number'))" :disabled="disabledObj['receive_room_number_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','receive_room_number')">{{form['receive_room_number']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','order_status') || $check_field('add','order_status') || $check_field('set','order_status')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="订单状态" prop="order_status">
								<el-select id="order_status" v-model="form['order_status']"
						v-if="user_group === '管理员' || (form['order_signing_id'] && $check_field('set','order_status')) || (!form['order_signing_id'] && $check_field('add','order_status'))">
						<el-option v-for="o in list_order_status" :key="o" :label="o" :value="o">
						</el-option>
					</el-select>
					<div v-else-if="$check_field('get','order_status')">{{form['order_status']}}</div>
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
				field: "order_signing_id",
				url_add: "~/api/order_signing/add?",
				url_set: "~/api/order_signing/set?",
				url_get_obj: "~/api/order_signing/get_obj?",
				url_upload: "~/api/order_signing/upload?",

				query: {
					"order_signing_id": 0,
				},

				form: {
								"supplier_no": 0, // 供应商编号
										"order_number":  '', // 订单号
										"user": 0, // 用户
										"trade_name":  '', // 商品名称
										"purchase_quantity":  '', // 购买数量
										"consignee_name":  '', // 收货人姓名
										"contact_number":  '', // 联系电话
										"receive_room_number":  '', // 收房间号
										"order_status":  '', // 订单状态
											"order_signing_id": 0, // ID
						
				},
				disabledObj:{
								"supplier_no_isDisabled": false,
										"order_number_isDisabled": false,
										"user_isDisabled": false,
										"trade_name_isDisabled": false,
										"purchase_quantity_isDisabled": false,
										"consignee_name_isDisabled": false,
										"contact_number_isDisabled": false,
										"receive_room_number_isDisabled": false,
										"order_status_isDisabled": false,
										},

	
					// 用户列表
				list_user_supplier_no: [],
				
		
					// 用户列表
				list_user_user: [],
				
		
		
		
		
						// 订单状态选项列表
				list_order_status: ['未完成','已完成'],
	
	
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
			 * 获取注册用户用户列表
			 */
			async get_list_user_user() {
                // if(this.user_group !== "管理员" && this.form["user"] === 0) {
                //     this.form["user"] = this.user.user_id;
                // }
                var json = await this.$get("~/api/user/get_list?user_group=注册用户");
                if(json.result && json.result.list){
                    this.list_user_user = json.result.list;
                }
                else if(json.error){
                    console.error(json.error);
                }
			},
					get_user_user(id){
				var obj = this.list_user_user.getObj({"user_id":id});
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
			 * 获取对象之前
			 * @param {Object} param
			 */
			get_obj_before(param) {
				var form = "";
																											// 获取缓存数据附加
				form = $.db.get("form");
							$.push(this.form ,form);
															
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
					bl = this.$check_action('/order_signing/table','add');
					console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
				}
				if(!bl){
					bl = this.$check_action('/order_signing/table','set');
					console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
				}
				if(!bl){
					bl = this.$check_action('/order_signing/view','add');
					console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
				}
				if(!bl){
					bl = this.$check_action('/order_signing/view','set');
					console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
				}
				if(!bl){
					bl = this.$check_action('/order_signing/view','get');
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
										this.get_list_user_user();
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
