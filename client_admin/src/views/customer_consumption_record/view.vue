<template>
	<el-main class="bg edit_wrap">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">

							<el-col v-if="user_group === '管理员' || $check_field('get','customer') || $check_field('add','customer') || $check_field('set','customer')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="客户" prop="customer">
													<el-select v-if="user_group === '管理员' || (form['customer_consumption_record_id'] && $check_field('set','customer')) || (!form['customer_consumption_record_id'] && $check_field('add','customer'))" id="customer" v-model="form['customer']" :disabled="disabledObj['customer_isDisabled']">
							<el-option v-for="o in list_user_customer" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
									   :value="o['user_id']">
							</el-option>
						</el-select>
						<el-select v-else-if="$check_field('get','customer')" id="customer" v-model="form['customer']" :disabled="true">
							<el-option v-for="o in list_user_customer" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
									   :value="o['user_id']">
							</el-option>
						</el-select>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','user_name') || $check_field('add','user_name') || $check_field('set','user_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="用户姓名" prop="user_name">
												<el-input id="user_name" v-model="form['user_name']" placeholder="请输入用户姓名"
							  v-if="user_group === '管理员' || (form['customer_consumption_record_id'] && $check_field('set','user_name')) || (!form['customer_consumption_record_id'] && $check_field('add','user_name'))" :disabled="disabledObj['user_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','user_name')">{{form['user_name']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','dissipate') || $check_field('add','dissipate') || $check_field('set','dissipate')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="消费时间" prop="dissipate">
								<el-date-picker :disabled="disabledObj['dissipate_isDisabled']" v-if="user_group === '管理员' || (form['customer_consumption_record_id'] && $check_field('set','dissipate')) || (!form['customer_consumption_record_id'] && $check_field('add','dissipate'))" id="dissipate"
						v-model="form['dissipate']" type="datetime" placeholder="选择日期时间">
					</el-date-picker>
					<div v-else-if="$check_field('get','dissipate')">{{form['dissipate']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','consumption_amount') || $check_field('add','consumption_amount') || $check_field('set','consumption_amount')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="消费金额" prop="consumption_amount">
								<el-input-number id="consumption_amount" v-model.number="form['consumption_amount']"
						v-if="user_group === '管理员' || (form['customer_consumption_record_id'] && $check_field('set','consumption_amount')) || (!form['customer_consumption_record_id'] && $check_field('add','consumption_amount'))" :disabled="disabledObj['consumption_amount_isDisabled']"></el-input-number>
					<div v-else-if="$check_field('get','consumption_amount')">{{form['consumption_amount']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','consumption_times') || $check_field('add','consumption_times') || $check_field('set','consumption_times')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="消费次数" prop="consumption_times">
												<el-input id="consumption_times" v-model="form['consumption_times']" placeholder="请输入消费次数"
							  v-if="user_group === '管理员' || (form['customer_consumption_record_id'] && $check_field('set','consumption_times')) || (!form['customer_consumption_record_id'] && $check_field('add','consumption_times'))" :disabled="disabledObj['consumption_times_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','consumption_times')">{{form['consumption_times']}}</div>
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
				field: "customer_consumption_record_id",
				url_add: "~/api/customer_consumption_record/add?",
				url_set: "~/api/customer_consumption_record/set?",
				url_get_obj: "~/api/customer_consumption_record/get_obj?",
				url_upload: "~/api/customer_consumption_record/upload?",

				query: {
					"customer_consumption_record_id": 0,
				},

				form: {
								"customer": 0, // 客户
										"user_name":  '', // 用户姓名
										"dissipate":  '', // 消费时间
										"consumption_amount":  0, // 消费金额
										"consumption_times":  '', // 消费次数
											"customer_consumption_record_id": 0, // ID
						
				},
				disabledObj:{
								"customer_isDisabled": false,
										"user_name_isDisabled": false,
										"dissipate_isDisabled": false,
					          			"consumption_amount_isDisabled": false,
										"consumption_times_isDisabled": false,
										},

	
					// 用户列表
				list_user_customer: [],
				
		
		
		
	
			}
		},
		methods: {


	
	
				/**
			 * 获取注册用户用户列表
			 */
			async get_list_user_customer() {
                // if(this.user_group !== "管理员" && this.form["customer"] === 0) {
                //     this.form["customer"] = this.user.user_id;
                // }
                var json = await this.$get("~/api/user/get_list?user_group=注册用户");
                if(json.result && json.result.list){
                    this.list_user_customer = json.result.list;
                }
                else if(json.error){
                    console.error(json.error);
                }
			},
					get_user_customer(id){
				var obj = this.list_user_customer.getObj({"user_id":id});
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
					        if (this.form["dissipate"].indexOf("-")===-1){
            this.form["dissipate"] = this.$toTime(parseInt(this.form["dissipate"]),"yyyy-MM-dd hh:mm:ss")
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


							        if(this.form["dissipate"]=="0000-00-00 00:00:00"){
          this.form["dissipate"] = null;
        }
				if(parseInt(this.form["dissipate"]) > 9999){
					this.form["dissipate"] = this.$toTime(parseInt(this.form["dissipate"]),"yyyy-MM-dd hh:mm:ss")
				}
									

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
					bl = this.$check_action('/customer_consumption_record/table','add');
					console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
				}
				if(!bl){
					bl = this.$check_action('/customer_consumption_record/table','set');
					console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
				}
				if(!bl){
					bl = this.$check_action('/customer_consumption_record/view','add');
					console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
				}
				if(!bl){
					bl = this.$check_action('/customer_consumption_record/view','set');
					console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
				}
				if(!bl){
					bl = this.$check_action('/customer_consumption_record/view','get');
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
					this.get_list_user_customer();
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
