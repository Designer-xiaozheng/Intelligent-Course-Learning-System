<template>
	<el-main class="bg edit_wrap">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">

							<el-col v-if="user_group === '管理员' || $check_field('get','month') || $check_field('add','month') || $check_field('set','month')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="月份" prop="month">
												<el-input id="month" v-model="form['month']" placeholder="请输入月份"
							  v-if="user_group === '管理员' || (form['business_records_id'] && $check_field('set','month')) || (!form['business_records_id'] && $check_field('add','month'))" :disabled="disabledObj['month_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','month')">{{form['month']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','business_date') || $check_field('add','business_date') || $check_field('set','business_date')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="营业日期" prop="business_date">
								<el-date-picker :disabled="disabledObj['business_date_isDisabled']" v-if="user_group === '管理员' || (form['business_records_id'] && $check_field('set','business_date')) || (!form['business_records_id'] && $check_field('add','business_date'))" id="business_date"
						v-model="form['business_date']" type="date" placeholder="选择日期">
					</el-date-picker>
					<div v-else-if="$check_field('get','business_date')">{{form['business_date']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','turnover') || $check_field('add','turnover') || $check_field('set','turnover')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="营业额" prop="turnover">
								<el-input-number id="turnover" v-model.number="form['turnover']"
						v-if="user_group === '管理员' || (form['business_records_id'] && $check_field('set','turnover')) || (!form['business_records_id'] && $check_field('add','turnover'))" :disabled="disabledObj['turnover_isDisabled']"></el-input-number>
					<div v-else-if="$check_field('get','turnover')">{{form['turnover']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','number_of_customers') || $check_field('add','number_of_customers') || $check_field('set','number_of_customers')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="客户人数" prop="number_of_customers">
												<el-input id="number_of_customers" v-model="form['number_of_customers']" placeholder="请输入客户人数"
							  v-if="user_group === '管理员' || (form['business_records_id'] && $check_field('set','number_of_customers')) || (!form['business_records_id'] && $check_field('add','number_of_customers'))" :disabled="disabledObj['number_of_customers_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','number_of_customers')">{{form['number_of_customers']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','business_situation') || $check_field('add','business_situation') || $check_field('set','business_situation')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="营业情况" prop="business_situation">
								<el-input type="textarea" id="business_situation" v-model="form['business_situation']" placeholder="请输入营业情况"
						v-if="user_group === '管理员' || (form['business_records_id'] && $check_field('set','business_situation')) || (!form['business_records_id'] && $check_field('add','business_situation'))" :disabled="disabledObj['business_situation_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','business_situation')">{{form['business_situation']}}</div>
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
				field: "business_records_id",
				url_add: "~/api/business_records/add?",
				url_set: "~/api/business_records/set?",
				url_get_obj: "~/api/business_records/get_obj?",
				url_upload: "~/api/business_records/upload?",

				query: {
					"business_records_id": 0,
				},

				form: {
								"month":  '', // 月份
										"business_date":  '', // 营业日期
										"turnover":  0, // 营业额
										"number_of_customers":  '', // 客户人数
										"business_situation":  '', // 营业情况
											"business_records_id": 0, // ID
						
				},
				disabledObj:{
								"month_isDisabled": false,
										"business_date_isDisabled": false,
					          			"turnover_isDisabled": false,
										"number_of_customers_isDisabled": false,
										"business_situation_isDisabled": false,
										},

	
		
		
		
		
	
			}
		},
		methods: {


	
	
			
	
			
	
			
	
			
	
		
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
				        if (this.form["business_date"].indexOf("-")===-1){
          this.form["business_date"] = this.$toTime(parseInt(this.form["business_date"]),"yyyy-MM-dd")
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


					        if(this.form["business_date"]=="0000-00-00"){
          this.form["business_date"] = null;
        }
				if(parseInt(this.form["business_date"]) > 9999){
					this.form["business_date"] = this.$toTime(parseInt(this.form["business_date"]),"yyyy-MM-dd")
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
					bl = this.$check_action('/business_records/table','add');
					console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
				}
				if(!bl){
					bl = this.$check_action('/business_records/table','set');
					console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
				}
				if(!bl){
					bl = this.$check_action('/business_records/view','add');
					console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
				}
				if(!bl){
					bl = this.$check_action('/business_records/view','set');
					console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
				}
				if(!bl){
					bl = this.$check_action('/business_records/view','get');
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
