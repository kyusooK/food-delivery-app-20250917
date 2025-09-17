<template>

    <v-card outlined>
        <v-card-title>
            CreateOrder
        </v-card-title>

        <v-card-text>
            <Number label="CustomerId" v-model="value.customerId" :editMode="editMode"/>
            <Number label="RestaurantId" v-model="value.restaurantId" :editMode="editMode"/>
            <OrderLineList offline label="MenuItems" v-model="value.menuItems" :editMode="editMode" @change="change"/>
            <Number label="TotalPrice" v-model="value.totalPrice" :editMode="editMode"/>
            <String label="PaymentId" v-model="value.paymentId" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="createOrder"
            >
                CreateOrder
            </v-btn>
            
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="close"
            >
                Close
            </v-btn>
        </v-card-actions>
    </v-card>

</template>

<script>

export default {
    name: 'CreateOrderCommand',
    components:{
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.customerId = 0;
        this.value.restaurantId = 0;
        this.value.menuItems = [];
        this.value.totalPrice = 0;
        this.value.paymentId = '';
    },
    watch: {
    },
    methods: {
        createOrder() {
            this.$emit('createOrder', this.value);
        },
        close() {
            this.$emit('closeDialog');
        },
        change() {
            this.$emit("update:modelValue", this.value);
        },
    }
}
</script>

