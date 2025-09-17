<template>
    <v-container>
        <v-snackbar
            v-model="snackbar.status"
            :timeout="snackbar.timeout"
            :color="snackbar.color"
        >
            
            <v-btn style="margin-left: 80px;" text @click="snackbar.status = false">
                Close
            </v-btn>
        </v-snackbar>
        <div class="panel">
            <div class="gs-bundle-of-buttons" style="max-height:10vh;">
                <v-btn @click="addNewRow" @class="contrast-primary-text" small color="primary">
                    <v-icon small style="margin-left: -5px;">mdi-plus</v-icon>등록
                </v-btn>
                <v-btn :disabled="!selectedRow" style="margin-left: 5px;" @click="openEditDialog()" class="contrast-primary-text" small color="primary">
                    <v-icon small>mdi-pencil</v-icon>수정
                </v-btn>
                <v-btn style="margin-left: 5px;" @click="createOrderDialog = true" class="contrast-primary-text" small color="primary" >
                    <v-icon small>mdi-minus-circle-outline</v-icon>주문 생성
                </v-btn>
                <v-dialog v-model="createOrderDialog" width="500">
                    <CreateOrder
                        @closeDialog="createOrderDialog = false"
                        @createOrder="createOrder"
                    ></CreateOrder>
                </v-dialog>
                <v-btn :disabled="!selectedRow" style="margin-left: 5px;" @click="pickUpFoodDialog = true" class="contrast-primary-text" small color="primary" >
                    <v-icon small>mdi-minus-circle-outline</v-icon>음식 수령
                </v-btn>
                <v-dialog v-model="pickUpFoodDialog" width="500">
                    <PickUpFood
                        @closeDialog="pickUpFoodDialog = false"
                        @pickUpFood="pickUpFood"
                    ></PickUpFood>
                </v-dialog>
                <v-btn :disabled="!selectedRow" style="margin-left: 5px;" @click="startCookingDialog = true" class="contrast-primary-text" small color="primary" >
                    <v-icon small>mdi-minus-circle-outline</v-icon>조리 시작
                </v-btn>
                <v-dialog v-model="startCookingDialog" width="500">
                    <StartCooking
                        @closeDialog="startCookingDialog = false"
                        @startCooking="startCooking"
                    ></StartCooking>
                </v-dialog>
                <v-btn :disabled="!selectedRow" style="margin-left: 5px;" @click="completeCookingDialog = true" class="contrast-primary-text" small color="primary" >
                    <v-icon small>mdi-minus-circle-outline</v-icon>조리 완료
                </v-btn>
                <v-dialog v-model="completeCookingDialog" width="500">
                    <CompleteCooking
                        @closeDialog="completeCookingDialog = false"
                        @completeCooking="completeCooking"
                    ></CompleteCooking>
                </v-dialog>
                <v-btn :disabled="!selectedRow" style="margin-left: 5px;" @click="acceptDeliveryDialog = true" class="contrast-primary-text" small color="primary" >
                    <v-icon small>mdi-minus-circle-outline</v-icon>배달 수락
                </v-btn>
                <v-dialog v-model="acceptDeliveryDialog" width="500">
                    <AcceptDelivery
                        @closeDialog="acceptDeliveryDialog = false"
                        @acceptDelivery="acceptDelivery"
                    ></AcceptDelivery>
                </v-dialog>
                <v-btn :disabled="!selectedRow" style="margin-left: 5px;" @click="confirmDeliveryDialog = true" class="contrast-primary-text" small color="primary" >
                    <v-icon small>mdi-minus-circle-outline</v-icon>배달 수령 확인
                </v-btn>
                <v-dialog v-model="confirmDeliveryDialog" width="500">
                    <ConfirmDelivery
                        @closeDialog="confirmDeliveryDialog = false"
                        @confirmDelivery="confirmDelivery"
                    ></ConfirmDelivery>
                </v-dialog>
                <v-btn :disabled="!selectedRow" style="margin-left: 5px;" @click="deliverFoodDialog = true" class="contrast-primary-text" small color="primary" >
                    <v-icon small>mdi-minus-circle-outline</v-icon>음식 배달 완료
                </v-btn>
                <v-dialog v-model="deliverFoodDialog" width="500">
                    <DeliverFood
                        @closeDialog="deliverFoodDialog = false"
                        @deliverFood="deliverFood"
                    ></DeliverFood>
                </v-dialog>
                <v-btn :disabled="!selectedRow" style="margin-left: 5px;" @click="cancelOrderDialog = true" class="contrast-primary-text" small color="primary" >
                    <v-icon small>mdi-minus-circle-outline</v-icon>주문 취소
                </v-btn>
                <v-dialog v-model="cancelOrderDialog" width="500">
                    <CancelOrder
                        @closeDialog="cancelOrderDialog = false"
                        @cancelOrder="cancelOrder"
                    ></CancelOrder>
                </v-dialog>
                <v-btn :disabled="!selectedRow" style="margin-left: 5px;" @click="assignDeliveryDialog = true" class="contrast-primary-text" small color="primary" >
                    <v-icon small>mdi-minus-circle-outline</v-icon>배달 배정
                </v-btn>
                <v-dialog v-model="assignDeliveryDialog" width="500">
                    <AssignDelivery
                        @closeDialog="assignDeliveryDialog = false"
                        @assignDelivery="assignDelivery"
                    ></AssignDelivery>
                </v-dialog>
                <v-btn :disabled="!selectedRow" style="margin-left: 5px;" @click="receiveOrderDialog = true" class="contrast-primary-text" small color="primary" >
                    <v-icon small>mdi-minus-circle-outline</v-icon>주문 접수
                </v-btn>
                <v-dialog v-model="receiveOrderDialog" width="500">
                    <ReceiveOrder
                        @closeDialog="receiveOrderDialog = false"
                        @receiveOrder="receiveOrder"
                    ></ReceiveOrder>
                </v-dialog>
                <v-btn :disabled="!selectedRow" style="margin-left: 5px;" @click="rejectDeliveryDialog = true" class="contrast-primary-text" small color="primary" >
                    <v-icon small>mdi-minus-circle-outline</v-icon>배달 거절
                </v-btn>
                <v-dialog v-model="rejectDeliveryDialog" width="500">
                    <RejectDelivery
                        @closeDialog="rejectDeliveryDialog = false"
                        @rejectDelivery="rejectDelivery"
                    ></RejectDelivery>
                </v-dialog>
            </div>
            <OrderStatusTracking @search="search" style="margin-bottom: 10px; background-color: #ffffff;"></OrderStatusTracking>
            <OrderDetails @search="search" style="margin-bottom: 10px; background-color: #ffffff;"></OrderDetails>
            <DeliveryHistoryList @search="search" style="margin-bottom: 10px; background-color: #ffffff;"></DeliveryHistoryList>
            <div class="mb-5 text-lg font-bold"></div>
            <div class="table-responsive">
                <v-table>
                    <thead>
                        <tr>
                        <th>Id</th>
                        <th>CustomerId</th>
                        <th>RestaurantId</th>
                        <th>DeliveryRiderId</th>
                        <th>OrderStatus</th>
                        <th>DeliveryStatus</th>
                        <th>PaymentStatus</th>
                        <th>PaymentId</th>
                        <th>MenuItems</th>
                        <th>TotalPrice</th>
                        <th>OrderCreatedAt</th>
                        <th>OrderUpdatedAt</th>
                        <th>OrderCancelledAt</th>
                        <th>CancelReason</th>
                        <th>CookingStartedAt</th>
                        <th>CookingCompletedAt</th>
                        <th>DeliveryAssignedAt</th>
                        <th>DeliveryAcceptedAt</th>
                        <th>DeliveryRejectedAt</th>
                        <th>FoodPickedUpAt</th>
                        <th>FoodDeliveredAt</th>
                        <th>DeliveryConfirmedAt</th>
                        <th>CustomerAddress</th>
                        <th>RestaurantAddress</th>
                        <th>DeliveryAddress</th>
                        <th>DeliveryTrackingLocation</th>
                        <th>ReviewAvailable</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr v-for="(val, idx) in value" 
                            @click="changeSelectedRow(val)"
                            :key="val"  
                            :style="val === selectedRow ? 'background-color: rgb(var(--v-theme-primary), 0.2) !important;':''"
                        >
                            <td class="font-semibold">{{ idx + 1 }}</td>
                            <td class="whitespace-nowrap" label="CustomerId">{{ val.customerId }}</td>
                            <td class="whitespace-nowrap" label="RestaurantId">{{ val.restaurantId }}</td>
                            <td class="whitespace-nowrap" label="DeliveryRiderId">{{ val.deliveryRiderId }}</td>
                            <td class="whitespace-nowrap" label="OrderStatus">{{ val.orderStatus }}</td>
                            <td class="whitespace-nowrap" label="DeliveryStatus">{{ val.deliveryStatus }}</td>
                            <td class="whitespace-nowrap" label="PaymentStatus">{{ val.paymentStatus }}</td>
                            <td class="whitespace-nowrap" label="PaymentId">{{ val.paymentId }}</td>
                            <td class="whitespace-nowrap" label="MenuItems">
                                <span v-for="(name, index) in val.menuItems" :key="index">
                                    {{ name }}<br>
                                </span>
                            </td>
                            <td class="whitespace-nowrap" label="TotalPrice">{{ val.totalPrice }}</td>
                            <td class="whitespace-nowrap" label="OrderCreatedAt">{{ val.orderCreatedAt }}</td>
                            <td class="whitespace-nowrap" label="OrderUpdatedAt">{{ val.orderUpdatedAt }}</td>
                            <td class="whitespace-nowrap" label="OrderCancelledAt">{{ val.orderCancelledAt }}</td>
                            <td class="whitespace-nowrap" label="CancelReason">{{ val.cancelReason }}</td>
                            <td class="whitespace-nowrap" label="CookingStartedAt">{{ val.cookingStartedAt }}</td>
                            <td class="whitespace-nowrap" label="CookingCompletedAt">{{ val.cookingCompletedAt }}</td>
                            <td class="whitespace-nowrap" label="DeliveryAssignedAt">{{ val.deliveryAssignedAt }}</td>
                            <td class="whitespace-nowrap" label="DeliveryAcceptedAt">{{ val.deliveryAcceptedAt }}</td>
                            <td class="whitespace-nowrap" label="DeliveryRejectedAt">{{ val.deliveryRejectedAt }}</td>
                            <td class="whitespace-nowrap" label="FoodPickedUpAt">{{ val.foodPickedUpAt }}</td>
                            <td class="whitespace-nowrap" label="FoodDeliveredAt">{{ val.foodDeliveredAt }}</td>
                            <td class="whitespace-nowrap" label="DeliveryConfirmedAt">{{ val.deliveryConfirmedAt }}</td>
                            <td class="whitespace-nowrap" label="CustomerAddress">{{ val.customerAddress }}</td>
                            <td class="whitespace-nowrap" label="RestaurantAddress">{{ val.restaurantAddress }}</td>
                            <td class="whitespace-nowrap" label="DeliveryAddress">{{ val.deliveryAddress }}</td>
                            <td class="whitespace-nowrap" label="DeliveryTrackingLocation">{{ val.deliveryTrackingLocation }}</td>
                            <td class="whitespace-nowrap" label="ReviewAvailable">{{ val.reviewAvailable }}</td>
                            <v-row class="ma-0 pa-4 align-center">
                                <v-spacer></v-spacer>
                                <Icon style="cursor: pointer;" icon="mi:delete" @click="deleteRow(val)" />
                            </v-row>
                        </tr>
                    </tbody>
                </v-table>
            </div>
            <OrderLineDetailGrid style="margin-top: 20px;" label="MenuItems" offline v-if="selectedRow" v-model="selectedRow.menuItems" :selectedRow="selectedRow"/>
        </div>
        <v-col>
            <v-dialog
                v-model="openDialog"
                transition="dialog-bottom-transition"
                width="35%"
            >
                <v-card>
                    <v-toolbar
                        color="primary"
                        class="elevation-0 pa-4"
                        height="50px"
                    >
                        <div style="color:white; font-size:17px; font-weight:700;">Order 등록</div>
                        <v-spacer></v-spacer>
                        <v-icon
                            color="white"
                            small
                            @click="closeDialog()"
                        >mdi-close</v-icon>
                    </v-toolbar>
                    <v-card-text>
                        <Order :offline="offline"
                            :isNew="!value.idx"
                            :editMode="true"
                            :inList="false"
                            v-model="newValue"
                            @add="append"
                        />
                    </v-card-text>
                </v-card>
            </v-dialog>
            <v-dialog
                v-model="editDialog"
                transition="dialog-bottom-transition"
                width="35%"
            >
                <v-card>
                    <v-toolbar
                        color="primary"
                        class="elevation-0 pa-4"
                        height="50px"
                    >
                        <div style="color:white; font-size:17px; font-weight:700;">Order 수정</div>
                        <v-spacer></v-spacer>
                        <v-icon
                            color="white"
                            small
                            @click="closeDialog()"
                        >mdi-close</v-icon>
                    </v-toolbar>
                    <v-card-text>
                        <div>
                            <Number label="OrderId" v-model="selectedRow.orderId" :editMode="true"/>
                            <Number label="CustomerId" v-model="selectedRow.customerId" :editMode="true"/>
                            <Number label="RestaurantId" v-model="selectedRow.restaurantId" :editMode="true"/>
                            <Number label="DeliveryRiderId" v-model="selectedRow.deliveryRiderId" :editMode="true"/>
                            <String label="PaymentId" v-model="selectedRow.paymentId" :editMode="true"/>
                            <Number label="TotalPrice" v-model="selectedRow.totalPrice" :editMode="true"/>
                            <Date label="OrderCreatedAt" v-model="selectedRow.orderCreatedAt" :editMode="true"/>
                            <Date label="OrderUpdatedAt" v-model="selectedRow.orderUpdatedAt" :editMode="true"/>
                            <Date label="OrderCancelledAt" v-model="selectedRow.orderCancelledAt" :editMode="true"/>
                            <String label="CancelReason" v-model="selectedRow.cancelReason" :editMode="true"/>
                            <Date label="CookingStartedAt" v-model="selectedRow.cookingStartedAt" :editMode="true"/>
                            <Date label="CookingCompletedAt" v-model="selectedRow.cookingCompletedAt" :editMode="true"/>
                            <Date label="DeliveryAssignedAt" v-model="selectedRow.deliveryAssignedAt" :editMode="true"/>
                            <Date label="DeliveryAcceptedAt" v-model="selectedRow.deliveryAcceptedAt" :editMode="true"/>
                            <Date label="DeliveryRejectedAt" v-model="selectedRow.deliveryRejectedAt" :editMode="true"/>
                            <Date label="FoodPickedUpAt" v-model="selectedRow.foodPickedUpAt" :editMode="true"/>
                            <Date label="FoodDeliveredAt" v-model="selectedRow.foodDeliveredAt" :editMode="true"/>
                            <Date label="DeliveryConfirmedAt" v-model="selectedRow.deliveryConfirmedAt" :editMode="true"/>
                            <String label="CustomerAddress" v-model="selectedRow.customerAddress" :editMode="true"/>
                            <String label="RestaurantAddress" v-model="selectedRow.restaurantAddress" :editMode="true"/>
                            <String label="DeliveryAddress" v-model="selectedRow.deliveryAddress" :editMode="true"/>
                            <String label="DeliveryTrackingLocation" v-model="selectedRow.deliveryTrackingLocation" :editMode="true"/>
                            <Boolean label="ReviewAvailable" v-model="selectedRow.reviewAvailable" :editMode="true"/>
                            <OrderStatus offline label="OrderStatus" v-model="selectedRow.orderStatus" :editMode="true"/>
                            <DeliveryStatus offline label="DeliveryStatus" v-model="selectedRow.deliveryStatus" :editMode="true"/>
                            <PaymentStatus offline label="PaymentStatus" v-model="selectedRow.paymentStatus" :editMode="true"/>
                            <OrderLineDetailGrid label="MenuItems" offline v-model="selectedRow.menuItems" :editMode="true"/>
                            <v-divider class="border-opacity-100 my-divider"></v-divider>
                            <v-layout row justify-end>
                                <v-btn
                                    width="64px"
                                    color="primary"
                                    @click="save"
                                >
                                    수정
                                </v-btn>
                            </v-layout>
                        </div>
                    </v-card-text>
                </v-card>
            </v-dialog>
        </v-col>
    </v-container>
</template>

<script>
import { ref } from 'vue';
import { useTheme } from 'vuetify';
import BaseGrid from '../base-ui/BaseGrid.vue'


export default {
    name: 'orderGrid',
    mixins:[BaseGrid],
    components:{
    },
    data: () => ({
        path: 'orders',
        createOrderDialog: false,
        pickUpFoodDialog: false,
        startCookingDialog: false,
        completeCookingDialog: false,
        acceptDeliveryDialog: false,
        confirmDeliveryDialog: false,
        deliverFoodDialog: false,
        cancelOrderDialog: false,
        assignDeliveryDialog: false,
        receiveOrderDialog: false,
        rejectDeliveryDialog: false,
    }),
    watch: {
    },
    methods:{
        async createOrder(params){
            try{
                var path = "createOrder".toLowerCase();
                var temp = await this.repository.invoke(this.selectedRow, path, params)
                // 스넥바 관련 수정 필요
                // this.$EventBus.$emit('show-success','CreateOrder 성공적으로 처리되었습니다.')
                for(var i = 0; i< this.value.length; i++){
                    if(this.value[i] == this.selectedRow){
                        this.value[i] = temp.data
                    }
                }
                this.createOrderDialog = false
            }catch(e){
                console.log(e)
            }
        },
        async pickUpFood(params){
            try{
                var path = "pickUpFood".toLowerCase();
                var temp = await this.repository.invoke(this.selectedRow, path, params)
                // 스넥바 관련 수정 필요
                // this.$EventBus.$emit('show-success','PickUpFood 성공적으로 처리되었습니다.')
                for(var i = 0; i< this.value.length; i++){
                    if(this.value[i] == this.selectedRow){
                        this.value[i] = temp.data
                    }
                }
                this.pickUpFoodDialog = false
            }catch(e){
                console.log(e)
            }
        },
        async startCooking(params){
            try{
                var path = "startCooking".toLowerCase();
                var temp = await this.repository.invoke(this.selectedRow, path, params)
                // 스넥바 관련 수정 필요
                // this.$EventBus.$emit('show-success','StartCooking 성공적으로 처리되었습니다.')
                for(var i = 0; i< this.value.length; i++){
                    if(this.value[i] == this.selectedRow){
                        this.value[i] = temp.data
                    }
                }
                this.startCookingDialog = false
            }catch(e){
                console.log(e)
            }
        },
        async completeCooking(params){
            try{
                var path = "completeCooking".toLowerCase();
                var temp = await this.repository.invoke(this.selectedRow, path, params)
                // 스넥바 관련 수정 필요
                // this.$EventBus.$emit('show-success','CompleteCooking 성공적으로 처리되었습니다.')
                for(var i = 0; i< this.value.length; i++){
                    if(this.value[i] == this.selectedRow){
                        this.value[i] = temp.data
                    }
                }
                this.completeCookingDialog = false
            }catch(e){
                console.log(e)
            }
        },
        async acceptDelivery(params){
            try{
                var path = "acceptDelivery".toLowerCase();
                var temp = await this.repository.invoke(this.selectedRow, path, params)
                // 스넥바 관련 수정 필요
                // this.$EventBus.$emit('show-success','AcceptDelivery 성공적으로 처리되었습니다.')
                for(var i = 0; i< this.value.length; i++){
                    if(this.value[i] == this.selectedRow){
                        this.value[i] = temp.data
                    }
                }
                this.acceptDeliveryDialog = false
            }catch(e){
                console.log(e)
            }
        },
        async confirmDelivery(params){
            try{
                var path = "confirmDelivery".toLowerCase();
                var temp = await this.repository.invoke(this.selectedRow, path, params)
                // 스넥바 관련 수정 필요
                // this.$EventBus.$emit('show-success','ConfirmDelivery 성공적으로 처리되었습니다.')
                for(var i = 0; i< this.value.length; i++){
                    if(this.value[i] == this.selectedRow){
                        this.value[i] = temp.data
                    }
                }
                this.confirmDeliveryDialog = false
            }catch(e){
                console.log(e)
            }
        },
        async deliverFood(params){
            try{
                var path = "deliverFood".toLowerCase();
                var temp = await this.repository.invoke(this.selectedRow, path, params)
                // 스넥바 관련 수정 필요
                // this.$EventBus.$emit('show-success','DeliverFood 성공적으로 처리되었습니다.')
                for(var i = 0; i< this.value.length; i++){
                    if(this.value[i] == this.selectedRow){
                        this.value[i] = temp.data
                    }
                }
                this.deliverFoodDialog = false
            }catch(e){
                console.log(e)
            }
        },
        async cancelOrder(params){
            try{
                var path = "cancelOrder".toLowerCase();
                var temp = await this.repository.invoke(this.selectedRow, path, params)
                // 스넥바 관련 수정 필요
                // this.$EventBus.$emit('show-success','CancelOrder 성공적으로 처리되었습니다.')
                for(var i = 0; i< this.value.length; i++){
                    if(this.value[i] == this.selectedRow){
                        this.value[i] = temp.data
                    }
                }
                this.cancelOrderDialog = false
            }catch(e){
                console.log(e)
            }
        },
        async assignDelivery(params){
            try{
                var path = "assignDelivery".toLowerCase();
                var temp = await this.repository.invoke(this.selectedRow, path, params)
                // 스넥바 관련 수정 필요
                // this.$EventBus.$emit('show-success','AssignDelivery 성공적으로 처리되었습니다.')
                for(var i = 0; i< this.value.length; i++){
                    if(this.value[i] == this.selectedRow){
                        this.value[i] = temp.data
                    }
                }
                this.assignDeliveryDialog = false
            }catch(e){
                console.log(e)
            }
        },
        async receiveOrder(params){
            try{
                var path = "receiveOrder".toLowerCase();
                var temp = await this.repository.invoke(this.selectedRow, path, params)
                // 스넥바 관련 수정 필요
                // this.$EventBus.$emit('show-success','ReceiveOrder 성공적으로 처리되었습니다.')
                for(var i = 0; i< this.value.length; i++){
                    if(this.value[i] == this.selectedRow){
                        this.value[i] = temp.data
                    }
                }
                this.receiveOrderDialog = false
            }catch(e){
                console.log(e)
            }
        },
        async rejectDelivery(params){
            try{
                var path = "rejectDelivery".toLowerCase();
                var temp = await this.repository.invoke(this.selectedRow, path, params)
                // 스넥바 관련 수정 필요
                // this.$EventBus.$emit('show-success','RejectDelivery 성공적으로 처리되었습니다.')
                for(var i = 0; i< this.value.length; i++){
                    if(this.value[i] == this.selectedRow){
                        this.value[i] = temp.data
                    }
                }
                this.rejectDeliveryDialog = false
            }catch(e){
                console.log(e)
            }
        },
    }
}

</script>