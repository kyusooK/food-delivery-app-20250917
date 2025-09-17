<template>
    <div>
        <Number
            label="OrderId"
            v-model="value.orderId"
            :editMode="editMode"
        />
        <Number
            label="CustomerId"
            v-model="value.customerId"
            :editMode="editMode"
        />
        <Number
            label="RestaurantId"
            v-model="value.restaurantId"
            :editMode="editMode"
        />
        <Number
            label="DeliveryRiderId"
            v-model="value.deliveryRiderId"
            :editMode="editMode"
        />
        <String
            label="PaymentId"
            v-model="value.paymentId"
            :editMode="editMode"
        />
        <div variant="outlined" class="my-2">
            <MenuItems v-model="menuItemsInput"
                offline
                label="MenuItems"
                :editMode="editMode"
                @change="change"
            />
            <v-row class="ma-0 pa-0 mt-2">
                <v-spacer></v-spacer>
                <v-btn @click="addMenuItemsList">MenuItems Add</v-btn>
            </v-row>
            <v-card v-if="value.menuItems.length > 0" variant="outlined" class="pa-4 mt-2">
                <v-card-sub-title>
                    MenuItems List
                </v-card-sub-title>
                <li v-for="(id, index) in value.menuItems" :key="index">
                    {{ id && id. ? id. : '' }}
                </li>
            </v-card>
        </div>
        <Number
            label="TotalPrice"
            v-model="value.totalPrice"
            :editMode="editMode"
        />
        <Date
            label="OrderCreatedAt"
            v-model="value.orderCreatedAt"
            :editMode="editMode"
        />
        <Date
            label="OrderUpdatedAt"
            v-model="value.orderUpdatedAt"
            :editMode="editMode"
        />
        <Date
            label="OrderCancelledAt"
            v-model="value.orderCancelledAt"
            :editMode="editMode"
        />
        <String
            label="CancelReason"
            v-model="value.cancelReason"
            :editMode="editMode"
        />
        <Date
            label="CookingStartedAt"
            v-model="value.cookingStartedAt"
            :editMode="editMode"
        />
        <Date
            label="CookingCompletedAt"
            v-model="value.cookingCompletedAt"
            :editMode="editMode"
        />
        <Date
            label="DeliveryAssignedAt"
            v-model="value.deliveryAssignedAt"
            :editMode="editMode"
        />
        <Date
            label="DeliveryAcceptedAt"
            v-model="value.deliveryAcceptedAt"
            :editMode="editMode"
        />
        <Date
            label="DeliveryRejectedAt"
            v-model="value.deliveryRejectedAt"
            :editMode="editMode"
        />
        <Date
            label="FoodPickedUpAt"
            v-model="value.foodPickedUpAt"
            :editMode="editMode"
        />
        <Date
            label="FoodDeliveredAt"
            v-model="value.foodDeliveredAt"
            :editMode="editMode"
        />
        <Date
            label="DeliveryConfirmedAt"
            v-model="value.deliveryConfirmedAt"
            :editMode="editMode"
        />
        <String
            label="CustomerAddress"
            v-model="value.customerAddress"
            :editMode="editMode"
        />
        <String
            label="RestaurantAddress"
            v-model="value.restaurantAddress"
            :editMode="editMode"
        />
        <String
            label="DeliveryAddress"
            v-model="value.deliveryAddress"
            :editMode="editMode"
        />
        <String
            label="DeliveryTrackingLocation"
            v-model="value.deliveryTrackingLocation"
            :editMode="editMode"
        />
        <Boolean
            label="ReviewAvailable"
            v-model="value.reviewAvailable"
            :editMode="editMode"
        />
        <OrderStatus
            offline
            label="OrderStatus"
            v-model="value.orderStatus"
            :editMode="editMode"
            @change="change"
        />
        <DeliveryStatus
            offline
            label="DeliveryStatus"
            v-model="value.deliveryStatus"
            :editMode="editMode"
            @change="change"
        />
        <PaymentStatus
            offline
            label="PaymentStatus"
            v-model="value.paymentStatus"
            :editMode="editMode"
            @change="change"
        />
        <v-row class="ma-0 pa-0">
            <v-spacer></v-spacer>
            <v-btn width="64px" color="primary" @click="save">
                저장
            </v-btn>
        </v-row>
    </div>
</template>


<script>
import BaseEntity from './base-ui/BaseEntity.vue'

export default {
    name: 'Order',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "orders",
        menuItemsInput: null,
        value: {
            menuItems: [],
        }
    }),
    created(){
    },
    computed:{
    },
    methods: {
        addMenuItemsList() {
            if (this.menuItemsInput !== null && this.menuItemsInput !== '') {
                this.value.menuItems.push(this.menuItemsInput);
                this.menuItemsInput = null; // null로 초기화
            }
        },
    },
}
</script>
