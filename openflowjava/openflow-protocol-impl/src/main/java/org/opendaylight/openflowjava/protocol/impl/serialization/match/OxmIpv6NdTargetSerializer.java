/*
 * Copyright (c) 2013 Pantheon Technologies s.r.o. and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.openflowjava.protocol.impl.serialization.match;

import io.netty.buffer.ByteBuf;
import org.opendaylight.openflowjava.protocol.api.util.EncodeConstants;
import org.opendaylight.openflowjava.protocol.api.util.OxmMatchConstants;
import org.opendaylight.yang.gen.v1.urn.opendaylight.openflow.oxm.rev150225.match.entries.grouping.MatchEntry;
import org.opendaylight.yang.gen.v1.urn.opendaylight.openflow.oxm.rev150225.match.entry.value.grouping.match.entry.value.Ipv6NdTargetCase;

/**
 * OxmIpv6Nd match entry serializer.
 *
 * @author michal.polkorab
 */
public class OxmIpv6NdTargetSerializer extends AbstractOxmIpv6AddressSerializer {

    @Override
    public void serialize(MatchEntry entry, ByteBuf outBuffer) {
        super.serialize(entry, outBuffer);
        Ipv6NdTargetCase entryValue = (Ipv6NdTargetCase) entry.getMatchEntryValue();
        writeIpv6Address(entryValue.getIpv6NdTarget().getIpv6Address().getValue(), outBuffer);
    }

    @Override
    protected int getOxmClassCode() {
        return OxmMatchConstants.OPENFLOW_BASIC_CLASS;
    }

    @Override
    protected int getOxmFieldCode() {
        return OxmMatchConstants.IPV6_ND_TARGET;
    }

    @Override
    protected int getValueLength() {
        return EncodeConstants.SIZE_OF_IPV6_ADDRESS_IN_BYTES;
    }
}
