<template>

    <v-data-table
        :headers="headers"
        :items="phone"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'PhoneView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
                { text: "userId", value: "userId" },
                { text: "phoneId", value: "phoneId" },
                { text: "imei", value: "imei" },
                { text: "lostStatus", value: "lostStatus" },
                { text: "imeiLockStatus", value: "imeiLockStatus" },
                { text: "lockStatus", value: "lockStatus" },
                { text: "phoneChangeStatus", value: "phoneChangeStatus" },
                { text: "lostPhoneId", value: "lostPhoneId" },
            ],
            phone : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/phones'))

            temp.data._embedded.phones.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.phone = temp.data._embedded.phones;
        },
        methods: {
        }
    }
</script>

