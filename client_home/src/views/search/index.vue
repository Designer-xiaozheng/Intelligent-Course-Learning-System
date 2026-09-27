<template>
  <div class="page_search">
	<div class="warp">
	  <div class="container">
		<div class="row">
		  <div class="col-12">
			<div class="card_result_search">
			  <div class="title">搜索结果</div>

				<!-- 文章搜索结果 -->
			  <list_result_search
				:list="result_article"
				title="棋牌室资讯"
				source_table="article"
			  ></list_result_search>


						  <list_result_search
				v-if="$check_action('/registered_users/list', 'get')"
				:list="result_registered_users_user_name"
				title="注册用户用户姓名"
				source_table="registered_users"
			  ></list_result_search>
								  <list_result_search
				v-if="$check_action('/registered_users/list', 'get')"
				:list="result_registered_users_gender"
				title="注册用户性别"
				source_table="registered_users"
			  ></list_result_search>
									  <list_result_search
				v-if="$check_action('/supplier/list', 'get')"
				:list="result_supplier_supplier_no"
				title="供应商供应商编号"
				source_table="supplier"
			  ></list_result_search>
								  <list_result_search
				v-if="$check_action('/supplier/list', 'get')"
				:list="result_supplier_supplier_name"
				title="供应商供应商姓名"
				source_table="supplier"
			  ></list_result_search>
									  <list_result_search
				v-if="$check_action('/staff/list', 'get')"
				:list="result_staff_employee_no"
				title="员工员工工号"
				source_table="staff"
			  ></list_result_search>
								  <list_result_search
				v-if="$check_action('/staff/list', 'get')"
				:list="result_staff_employee_name"
				title="员工员工姓名"
				source_table="staff"
			  ></list_result_search>
									  <list_result_search
				v-if="$check_action('/room_type/list', 'get')"
				:list="result_room_type_room_type"
				title="房间类型房间类型"
				source_table="room_type"
			  ></list_result_search>
												  <list_result_search
				v-if="$check_action('/chess_and_card_room/list', 'get')"
				:list="result_chess_and_card_room_room_type"
				title="棋牌房间房间类型"
				source_table="chess_and_card_room"
			  ></list_result_search>
								  <list_result_search
				v-if="$check_action('/chess_and_card_room/list', 'get')"
				:list="result_chess_and_card_room_number_of_rooms"
				title="棋牌房间房间数量"
				source_table="chess_and_card_room"
			  ></list_result_search>
																																	  <list_result_search
				v-if="$check_action('/room_reservation/list', 'get')"
				:list="result_room_reservation_user_name"
				title="房间预订用户姓名"
				source_table="room_reservation"
			  ></list_result_search>
											  <list_result_search
				v-if="$check_action('/room_reservation/list', 'get')"
				:list="result_room_reservation_reservation_time"
				title="房间预订预订时间"
				source_table="room_reservation"
			  ></list_result_search>
												  <list_result_search
				v-if="$check_action('/commodity_classification/list', 'get')"
				:list="result_commodity_classification_product_type"
				title="商品分类商品类型"
				source_table="commodity_classification"
			  ></list_result_search>
															  <list_result_search
				v-if="$check_action('/product_information/list', 'get')"
				:list="result_product_information_trade_name"
				title="商品信息商品名称"
				source_table="product_information"
			  ></list_result_search>
								  <list_result_search
				v-if="$check_action('/product_information/list', 'get')"
				:list="result_product_information_commodity_type"
				title="商品信息商品类型"
				source_table="product_information"
			  ></list_result_search>
																																				  <list_result_search
				v-if="$check_action('/commodity_retail/list', 'get')"
				:list="result_commodity_retail_trade_name"
				title="商品零售商品名称"
				source_table="commodity_retail"
			  ></list_result_search>
																				  <list_result_search
				v-if="$check_action('/commodity_retail/list', 'get')"
				:list="result_commodity_retail_purchase_quantity"
				title="商品零售购买数量"
				source_table="commodity_retail"
			  ></list_result_search>
																											  <list_result_search
				v-if="$check_action('/order_signing/list', 'get')"
				:list="result_order_signing_order_number"
				title="订单状态订单号"
				source_table="order_signing"
			  ></list_result_search>
											  <list_result_search
				v-if="$check_action('/order_signing/list', 'get')"
				:list="result_order_signing_trade_name"
				title="订单状态商品名称"
				source_table="order_signing"
			  ></list_result_search>
																											  <list_result_search
				v-if="$check_action('/business_records/list', 'get')"
				:list="result_business_records_business_date"
				title="营业记录营业日期"
				source_table="business_records"
			  ></list_result_search>
								  <list_result_search
				v-if="$check_action('/business_records/list', 'get')"
				:list="result_business_records_turnover"
				title="营业记录营业额"
				source_table="business_records"
			  ></list_result_search>
																		  <list_result_search
				v-if="$check_action('/customer_consumption_record/list', 'get')"
				:list="result_customer_consumption_record_user_name"
				title="客户消费记录用户姓名"
				source_table="customer_consumption_record"
			  ></list_result_search>
								  <list_result_search
				v-if="$check_action('/customer_consumption_record/list', 'get')"
				:list="result_customer_consumption_record_dissipate"
				title="客户消费记录消费时间"
				source_table="customer_consumption_record"
			  ></list_result_search>
																		  <list_result_search
				v-if="$check_action('/employees_ask_for_leave/list', 'get')"
				:list="result_employees_ask_for_leave_employee_name"
				title="请假申请员工姓名"
				source_table="employees_ask_for_leave"
			  ></list_result_search>
								  <list_result_search
				v-if="$check_action('/employees_ask_for_leave/list', 'get')"
				:list="result_employees_ask_for_leave_leave_type"
				title="请假申请请假类型"
				source_table="employees_ask_for_leave"
			  ></list_result_search>
																								  <list_result_search
				v-if="$check_action('/employee_absenteeism/list', 'get')"
				:list="result_employee_absenteeism_employee_name"
				title="员工旷班员工姓名"
				source_table="employee_absenteeism"
			  ></list_result_search>
								  <list_result_search
				v-if="$check_action('/employee_absenteeism/list', 'get')"
				:list="result_employee_absenteeism_date_of_absenteeism"
				title="员工旷班旷班日期"
				source_table="employee_absenteeism"
			  ></list_result_search>
																		  <list_result_search
				v-if="$check_action('/employee_salary/list', 'get')"
				:list="result_employee_salary_employee_name"
				title="员工工资员工姓名"
				source_table="employee_salary"
			  ></list_result_search>
								  <list_result_search
				v-if="$check_action('/employee_salary/list', 'get')"
				:list="result_employee_salary_salary_month"
				title="员工工资发薪月份"
				source_table="employee_salary"
			  ></list_result_search>
																																				  <list_result_search
				v-if="$check_action('/employee_scheduling/list', 'get')"
				:list="result_employee_scheduling_employee_name"
				title="员工排班员工姓名"
				source_table="employee_scheduling"
			  ></list_result_search>
								  <list_result_search
				v-if="$check_action('/employee_scheduling/list', 'get')"
				:list="result_employee_scheduling_shift_month"
				title="员工排班排班月份"
				source_table="employee_scheduling"
			  ></list_result_search>
															  <list_result_search
				v-if="$check_action('/pay_month/list', 'get')"
				:list="result_pay_month_pay_month"
				title="发薪月份发薪月份"
				source_table="pay_month"
			  ></list_result_search>
															  <list_result_search
				v-if="$check_action('/employee_shift_hours/list', 'get')"
				:list="result_employee_shift_hours_date_of_work"
				title="员工班时上班日期"
				source_table="employee_shift_hours"
			  ></list_result_search>
								  <list_result_search
				v-if="$check_action('/employee_shift_hours/list', 'get')"
				:list="result_employee_shift_hours_shift_arrangement"
				title="员工班时排班班次"
				source_table="employee_shift_hours"
			  ></list_result_search>
															</div>
		  </div>
		</div>
	  </div>
	</div>
  </div>
</template>

<script>
import mixin from "../../mixins/page.js";
import list_result_search from "../../components/diy/list_result_search.vue";

export default {
  mixins: [mixin],
  data() {
	return {
	  "query": {
		word: "",
	  },
	  "result_article": [],
						"result_registered_users_user_name":[],
								"result_registered_users_gender":[],
									"result_supplier_supplier_no":[],
								"result_supplier_supplier_name":[],
									"result_staff_employee_no":[],
								"result_staff_employee_name":[],
									"result_room_type_room_type":[],
												"result_chess_and_card_room_room_type":[],
								"result_chess_and_card_room_number_of_rooms":[],
																																	"result_room_reservation_user_name":[],
											"result_room_reservation_reservation_time":[],
												"result_commodity_classification_product_type":[],
															"result_product_information_trade_name":[],
								"result_product_information_commodity_type":[],
																																				"result_commodity_retail_trade_name":[],
																				"result_commodity_retail_purchase_quantity":[],
																											"result_order_signing_order_number":[],
											"result_order_signing_trade_name":[],
																											"result_business_records_business_date":[],
								"result_business_records_turnover":[],
																		"result_customer_consumption_record_user_name":[],
								"result_customer_consumption_record_dissipate":[],
																		"result_employees_ask_for_leave_employee_name":[],
								"result_employees_ask_for_leave_leave_type":[],
																								"result_employee_absenteeism_employee_name":[],
								"result_employee_absenteeism_date_of_absenteeism":[],
																		"result_employee_salary_employee_name":[],
								"result_employee_salary_salary_month":[],
																																				"result_employee_scheduling_employee_name":[],
								"result_employee_scheduling_shift_month":[],
															"result_pay_month_pay_month":[],
															"result_employee_shift_hours_date_of_work":[],
								"result_employee_shift_hours_shift_arrangement":[],
													};
  },
  methods: {
	/**
	 * 获取文章
	 */
	get_article() {
	  this.$get("~/api/article/get_list?like=0", { page: 1, size: 10, title: this.query.word }, (json) => {
		if (json.result) {
		  this.result_article = json.result.list;
		}
	  });
	},

				/**
	 * 获取user_name
	 */
	get_registered_users_user_name(){
		this.$get("~/api/registered_users/get_list?like=0", { page: 1, size: 10, "user_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_registered_users_user_name = json.result.list;
			result_registered_users_user_name.map(o => o.title = o['user_name'])
	  			this.result_registered_users_user_name = result_registered_users_user_name
		 	}
		});
	},
						/**
	 * 获取gender
	 */
	get_registered_users_gender(){
		this.$get("~/api/registered_users/get_list?like=0", { page: 1, size: 10, "gender": this.query.word }, (json) => {
		  if (json.result) {
			var result_registered_users_gender = json.result.list;
			result_registered_users_gender.map(o => o.title = o['gender'])
	  			this.result_registered_users_gender = result_registered_users_gender
		 	}
		});
	},
							/**
	 * 获取supplier_no
	 */
	get_supplier_supplier_no(){
		this.$get("~/api/supplier/get_list?like=0", { page: 1, size: 10, "supplier_no": this.query.word }, (json) => {
		  if (json.result) {
			var result_supplier_supplier_no = json.result.list;
			result_supplier_supplier_no.map(o => o.title = o['supplier_no'])
	  			this.result_supplier_supplier_no = result_supplier_supplier_no
		 	}
		});
	},
						/**
	 * 获取supplier_name
	 */
	get_supplier_supplier_name(){
		this.$get("~/api/supplier/get_list?like=0", { page: 1, size: 10, "supplier_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_supplier_supplier_name = json.result.list;
			result_supplier_supplier_name.map(o => o.title = o['supplier_name'])
	  			this.result_supplier_supplier_name = result_supplier_supplier_name
		 	}
		});
	},
							/**
	 * 获取employee_no
	 */
	get_staff_employee_no(){
		this.$get("~/api/staff/get_list?like=0", { page: 1, size: 10, "employee_no": this.query.word }, (json) => {
		  if (json.result) {
			var result_staff_employee_no = json.result.list;
			result_staff_employee_no.map(o => o.title = o['employee_no'])
	  			this.result_staff_employee_no = result_staff_employee_no
		 	}
		});
	},
						/**
	 * 获取employee_name
	 */
	get_staff_employee_name(){
		this.$get("~/api/staff/get_list?like=0", { page: 1, size: 10, "employee_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_staff_employee_name = json.result.list;
			result_staff_employee_name.map(o => o.title = o['employee_name'])
	  			this.result_staff_employee_name = result_staff_employee_name
		 	}
		});
	},
							/**
	 * 获取room_type
	 */
	get_room_type_room_type(){
		this.$get("~/api/room_type/get_list?like=0", { page: 1, size: 10, "room_type": this.query.word }, (json) => {
		  if (json.result) {
			var result_room_type_room_type = json.result.list;
			result_room_type_room_type.map(o => o.title = o['room_type'])
	  			this.result_room_type_room_type = result_room_type_room_type
		 	}
		});
	},
										/**
	 * 获取room_type
	 */
	get_chess_and_card_room_room_type(){
		this.$get("~/api/chess_and_card_room/get_list?like=0", { page: 1, size: 10, "room_type": this.query.word }, (json) => {
		  if (json.result) {
			var result_chess_and_card_room_room_type = json.result.list;
			result_chess_and_card_room_room_type.map(o => o.title = o['room_type'])
	  			this.result_chess_and_card_room_room_type = result_chess_and_card_room_room_type
		 	}
		});
	},
						/**
	 * 获取number_of_rooms
	 */
	get_chess_and_card_room_number_of_rooms(){
		this.$get("~/api/chess_and_card_room/get_list?like=0", { page: 1, size: 10, "number_of_rooms": this.query.word }, (json) => {
		  if (json.result) {
			var result_chess_and_card_room_number_of_rooms = json.result.list;
			result_chess_and_card_room_number_of_rooms.map(o => o.title = o['number_of_rooms'])
	  			this.result_chess_and_card_room_number_of_rooms = result_chess_and_card_room_number_of_rooms
		 	}
		});
	},
																															/**
	 * 获取user_name
	 */
	get_room_reservation_user_name(){
		this.$get("~/api/room_reservation/get_list?like=0", { page: 1, size: 10, "user_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_room_reservation_user_name = json.result.list;
			result_room_reservation_user_name.map(o => o.title = o['user_name'])
	  			this.result_room_reservation_user_name = result_room_reservation_user_name
		 	}
		});
	},
									/**
	 * 获取reservation_time
	 */
	get_room_reservation_reservation_time(){
		this.$get("~/api/room_reservation/get_list?like=0", { page: 1, size: 10, "reservation_time": this.query.word }, (json) => {
		  if (json.result) {
			var result_room_reservation_reservation_time = json.result.list;
			result_room_reservation_reservation_time.map(o => o.title = o['reservation_time'])
	  			this.result_room_reservation_reservation_time = result_room_reservation_reservation_time
		 	}
		});
	},
										/**
	 * 获取product_type
	 */
	get_commodity_classification_product_type(){
		this.$get("~/api/commodity_classification/get_list?like=0", { page: 1, size: 10, "product_type": this.query.word }, (json) => {
		  if (json.result) {
			var result_commodity_classification_product_type = json.result.list;
			result_commodity_classification_product_type.map(o => o.title = o['product_type'])
	  			this.result_commodity_classification_product_type = result_commodity_classification_product_type
		 	}
		});
	},
													/**
	 * 获取trade_name
	 */
	get_product_information_trade_name(){
		this.$get("~/api/product_information/get_list?like=0", { page: 1, size: 10, "trade_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_product_information_trade_name = json.result.list;
			result_product_information_trade_name.map(o => o.title = o['trade_name'])
	  			this.result_product_information_trade_name = result_product_information_trade_name
		 	}
		});
	},
						/**
	 * 获取commodity_type
	 */
	get_product_information_commodity_type(){
		this.$get("~/api/product_information/get_list?like=0", { page: 1, size: 10, "commodity_type": this.query.word }, (json) => {
		  if (json.result) {
			var result_product_information_commodity_type = json.result.list;
			result_product_information_commodity_type.map(o => o.title = o['commodity_type'])
	  			this.result_product_information_commodity_type = result_product_information_commodity_type
		 	}
		});
	},
																																		/**
	 * 获取trade_name
	 */
	get_commodity_retail_trade_name(){
		this.$get("~/api/commodity_retail/get_list?like=0", { page: 1, size: 10, "trade_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_commodity_retail_trade_name = json.result.list;
			result_commodity_retail_trade_name.map(o => o.title = o['trade_name'])
	  			this.result_commodity_retail_trade_name = result_commodity_retail_trade_name
		 	}
		});
	},
																		/**
	 * 获取purchase_quantity
	 */
	get_commodity_retail_purchase_quantity(){
		this.$get("~/api/commodity_retail/get_list?like=0", { page: 1, size: 10, "purchase_quantity": this.query.word }, (json) => {
		  if (json.result) {
			var result_commodity_retail_purchase_quantity = json.result.list;
			result_commodity_retail_purchase_quantity.map(o => o.title = o['purchase_quantity'])
	  			this.result_commodity_retail_purchase_quantity = result_commodity_retail_purchase_quantity
		 	}
		});
	},
																									/**
	 * 获取order_number
	 */
	get_order_signing_order_number(){
		this.$get("~/api/order_signing/get_list?like=0", { page: 1, size: 10, "order_number": this.query.word }, (json) => {
		  if (json.result) {
			var result_order_signing_order_number = json.result.list;
			result_order_signing_order_number.map(o => o.title = o['order_number'])
	  			this.result_order_signing_order_number = result_order_signing_order_number
		 	}
		});
	},
									/**
	 * 获取trade_name
	 */
	get_order_signing_trade_name(){
		this.$get("~/api/order_signing/get_list?like=0", { page: 1, size: 10, "trade_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_order_signing_trade_name = json.result.list;
			result_order_signing_trade_name.map(o => o.title = o['trade_name'])
	  			this.result_order_signing_trade_name = result_order_signing_trade_name
		 	}
		});
	},
																									/**
	 * 获取business_date
	 */
	get_business_records_business_date(){
		this.$get("~/api/business_records/get_list?like=0", { page: 1, size: 10, "business_date": this.query.word }, (json) => {
		  if (json.result) {
			var result_business_records_business_date = json.result.list;
			result_business_records_business_date.map(o => o.title = o['business_date'])
	  			this.result_business_records_business_date = result_business_records_business_date
		 	}
		});
	},
						/**
	 * 获取turnover
	 */
	get_business_records_turnover(){
		this.$get("~/api/business_records/get_list?like=0", { page: 1, size: 10, "turnover": this.query.word }, (json) => {
		  if (json.result) {
			var result_business_records_turnover = json.result.list;
			result_business_records_turnover.map(o => o.title = o['turnover'])
	  			this.result_business_records_turnover = result_business_records_turnover
		 	}
		});
	},
																/**
	 * 获取user_name
	 */
	get_customer_consumption_record_user_name(){
		this.$get("~/api/customer_consumption_record/get_list?like=0", { page: 1, size: 10, "user_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_customer_consumption_record_user_name = json.result.list;
			result_customer_consumption_record_user_name.map(o => o.title = o['user_name'])
	  			this.result_customer_consumption_record_user_name = result_customer_consumption_record_user_name
		 	}
		});
	},
						/**
	 * 获取dissipate
	 */
	get_customer_consumption_record_dissipate(){
		this.$get("~/api/customer_consumption_record/get_list?like=0", { page: 1, size: 10, "dissipate": this.query.word }, (json) => {
		  if (json.result) {
			var result_customer_consumption_record_dissipate = json.result.list;
			result_customer_consumption_record_dissipate.map(o => o.title = o['dissipate'])
	  			this.result_customer_consumption_record_dissipate = result_customer_consumption_record_dissipate
		 	}
		});
	},
																/**
	 * 获取employee_name
	 */
	get_employees_ask_for_leave_employee_name(){
		this.$get("~/api/employees_ask_for_leave/get_list?like=0", { page: 1, size: 10, "employee_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_employees_ask_for_leave_employee_name = json.result.list;
			result_employees_ask_for_leave_employee_name.map(o => o.title = o['employee_name'])
	  			this.result_employees_ask_for_leave_employee_name = result_employees_ask_for_leave_employee_name
		 	}
		});
	},
						/**
	 * 获取leave_type
	 */
	get_employees_ask_for_leave_leave_type(){
		this.$get("~/api/employees_ask_for_leave/get_list?like=0", { page: 1, size: 10, "leave_type": this.query.word }, (json) => {
		  if (json.result) {
			var result_employees_ask_for_leave_leave_type = json.result.list;
			result_employees_ask_for_leave_leave_type.map(o => o.title = o['leave_type'])
	  			this.result_employees_ask_for_leave_leave_type = result_employees_ask_for_leave_leave_type
		 	}
		});
	},
																						/**
	 * 获取employee_name
	 */
	get_employee_absenteeism_employee_name(){
		this.$get("~/api/employee_absenteeism/get_list?like=0", { page: 1, size: 10, "employee_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_employee_absenteeism_employee_name = json.result.list;
			result_employee_absenteeism_employee_name.map(o => o.title = o['employee_name'])
	  			this.result_employee_absenteeism_employee_name = result_employee_absenteeism_employee_name
		 	}
		});
	},
						/**
	 * 获取date_of_absenteeism
	 */
	get_employee_absenteeism_date_of_absenteeism(){
		this.$get("~/api/employee_absenteeism/get_list?like=0", { page: 1, size: 10, "date_of_absenteeism": this.query.word }, (json) => {
		  if (json.result) {
			var result_employee_absenteeism_date_of_absenteeism = json.result.list;
			result_employee_absenteeism_date_of_absenteeism.map(o => o.title = o['date_of_absenteeism'])
	  			this.result_employee_absenteeism_date_of_absenteeism = result_employee_absenteeism_date_of_absenteeism
		 	}
		});
	},
																/**
	 * 获取employee_name
	 */
	get_employee_salary_employee_name(){
		this.$get("~/api/employee_salary/get_list?like=0", { page: 1, size: 10, "employee_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_employee_salary_employee_name = json.result.list;
			result_employee_salary_employee_name.map(o => o.title = o['employee_name'])
	  			this.result_employee_salary_employee_name = result_employee_salary_employee_name
		 	}
		});
	},
						/**
	 * 获取salary_month
	 */
	get_employee_salary_salary_month(){
		this.$get("~/api/employee_salary/get_list?like=0", { page: 1, size: 10, "salary_month": this.query.word }, (json) => {
		  if (json.result) {
			var result_employee_salary_salary_month = json.result.list;
			result_employee_salary_salary_month.map(o => o.title = o['salary_month'])
	  			this.result_employee_salary_salary_month = result_employee_salary_salary_month
		 	}
		});
	},
																																		/**
	 * 获取employee_name
	 */
	get_employee_scheduling_employee_name(){
		this.$get("~/api/employee_scheduling/get_list?like=0", { page: 1, size: 10, "employee_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_employee_scheduling_employee_name = json.result.list;
			result_employee_scheduling_employee_name.map(o => o.title = o['employee_name'])
	  			this.result_employee_scheduling_employee_name = result_employee_scheduling_employee_name
		 	}
		});
	},
						/**
	 * 获取shift_month
	 */
	get_employee_scheduling_shift_month(){
		this.$get("~/api/employee_scheduling/get_list?like=0", { page: 1, size: 10, "shift_month": this.query.word }, (json) => {
		  if (json.result) {
			var result_employee_scheduling_shift_month = json.result.list;
			result_employee_scheduling_shift_month.map(o => o.title = o['shift_month'])
	  			this.result_employee_scheduling_shift_month = result_employee_scheduling_shift_month
		 	}
		});
	},
													/**
	 * 获取pay_month
	 */
	get_pay_month_pay_month(){
		this.$get("~/api/pay_month/get_list?like=0", { page: 1, size: 10, "pay_month": this.query.word }, (json) => {
		  if (json.result) {
			var result_pay_month_pay_month = json.result.list;
			result_pay_month_pay_month.map(o => o.title = o['pay_month'])
	  			this.result_pay_month_pay_month = result_pay_month_pay_month
		 	}
		});
	},
													/**
	 * 获取date_of_work
	 */
	get_employee_shift_hours_date_of_work(){
		this.$get("~/api/employee_shift_hours/get_list?like=0", { page: 1, size: 10, "date_of_work": this.query.word }, (json) => {
		  if (json.result) {
			var result_employee_shift_hours_date_of_work = json.result.list;
			result_employee_shift_hours_date_of_work.map(o => o.title = o['date_of_work'])
	  			this.result_employee_shift_hours_date_of_work = result_employee_shift_hours_date_of_work
		 	}
		});
	},
						/**
	 * 获取shift_arrangement
	 */
	get_employee_shift_hours_shift_arrangement(){
		this.$get("~/api/employee_shift_hours/get_list?like=0", { page: 1, size: 10, "shift_arrangement": this.query.word }, (json) => {
		  if (json.result) {
			var result_employee_shift_hours_shift_arrangement = json.result.list;
			result_employee_shift_hours_shift_arrangement.map(o => o.title = o['shift_arrangement'])
	  			this.result_employee_shift_hours_shift_arrangement = result_employee_shift_hours_shift_arrangement
		 	}
		});
	},
												
  },
  components: { list_result_search },
	created(){
    this.query.word = this.$route.query.word || "";
  },
  mounted() {
	this.get_article();
					this.get_registered_users_user_name();
							this.get_registered_users_gender();
								this.get_supplier_supplier_no();
							this.get_supplier_supplier_name();
								this.get_staff_employee_no();
							this.get_staff_employee_name();
								this.get_room_type_room_type();
											this.get_chess_and_card_room_room_type();
							this.get_chess_and_card_room_number_of_rooms();
																																this.get_room_reservation_user_name();
										this.get_room_reservation_reservation_time();
											this.get_commodity_classification_product_type();
														this.get_product_information_trade_name();
							this.get_product_information_commodity_type();
																																			this.get_commodity_retail_trade_name();
																			this.get_commodity_retail_purchase_quantity();
																										this.get_order_signing_order_number();
										this.get_order_signing_trade_name();
																										this.get_business_records_business_date();
							this.get_business_records_turnover();
																	this.get_customer_consumption_record_user_name();
							this.get_customer_consumption_record_dissipate();
																	this.get_employees_ask_for_leave_employee_name();
							this.get_employees_ask_for_leave_leave_type();
																							this.get_employee_absenteeism_employee_name();
							this.get_employee_absenteeism_date_of_absenteeism();
																	this.get_employee_salary_employee_name();
							this.get_employee_salary_salary_month();
																																			this.get_employee_scheduling_employee_name();
							this.get_employee_scheduling_shift_month();
														this.get_pay_month_pay_month();
														this.get_employee_shift_hours_date_of_work();
							this.get_employee_shift_hours_shift_arrangement();
												  },
  watch: {
	$route() {
	  $.push(this.query, this.$route.query);
	  this.get_article();
				  this.get_registered_users_user_name();
						  this.get_registered_users_gender();
							  this.get_supplier_supplier_no();
						  this.get_supplier_supplier_name();
							  this.get_staff_employee_no();
						  this.get_staff_employee_name();
							  this.get_room_type_room_type();
										  this.get_chess_and_card_room_room_type();
						  this.get_chess_and_card_room_number_of_rooms();
																															  this.get_room_reservation_user_name();
									  this.get_room_reservation_reservation_time();
										  this.get_commodity_classification_product_type();
													  this.get_product_information_trade_name();
						  this.get_product_information_commodity_type();
																																		  this.get_commodity_retail_trade_name();
																		  this.get_commodity_retail_purchase_quantity();
																									  this.get_order_signing_order_number();
									  this.get_order_signing_trade_name();
																									  this.get_business_records_business_date();
						  this.get_business_records_turnover();
																  this.get_customer_consumption_record_user_name();
						  this.get_customer_consumption_record_dissipate();
																  this.get_employees_ask_for_leave_employee_name();
						  this.get_employees_ask_for_leave_leave_type();
																						  this.get_employee_absenteeism_employee_name();
						  this.get_employee_absenteeism_date_of_absenteeism();
																  this.get_employee_salary_employee_name();
						  this.get_employee_salary_salary_month();
																																		  this.get_employee_scheduling_employee_name();
						  this.get_employee_scheduling_shift_month();
													  this.get_pay_month_pay_month();
													  this.get_employee_shift_hours_date_of_work();
						  this.get_employee_shift_hours_shift_arrangement();
													},
  },
};
</script>

<style scoped>
.card_search {
  text-align: center;
}
.card_result_search>.title {
  text-align: center;
  padding: 10px 0;
}
</style>
