package org.apache.maven.surefire.report;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class ReportEntry
{
    private String source;

    private String name;

    private String group;

    private String message;

    private StackTraceWriter stackTraceWriter;

    public ReportEntry()
    {
    }

    public ReportEntry( Object source, String name, String message )
    {
        this( source.getClass().getName(), name, null, message );
    }

    public ReportEntry( Object source, String name, String group, String message )
    {
        this( source.getClass().getName(), name, group, message, null );
    }

    public ReportEntry( Object source, String name, String message, StackTraceWriter stackTraceWriter )
    {
        this( source.getClass().getName(), name, null, message, stackTraceWriter );
    }

    public ReportEntry( Object source, String name, String group, String message, StackTraceWriter stackTraceWriter )
    {
        this( source.getClass().getName(), name, group, message, stackTraceWriter );
    }
    
    public ReportEntry( String source, String name, String message )
    {
        this( source, name, null, message );
    }

    public ReportEntry( String source, String name, String group, String message )
    {
        this( source, name, group, message, null );
    }

    public ReportEntry( String source, String name, String message, StackTraceWriter stackTraceWriter )
    {
        this( source, name, null, message, stackTraceWriter );
    }

    public ReportEntry( String source, String name, String group, String message, StackTraceWriter stackTraceWriter )
    {
        if ( source == null )
        {
            throw new NullPointerException( "source is null" );
        }
        if ( name == null )
        {
            throw new NullPointerException( "name is null" );
        }
        if ( message == null )
        {
            throw new NullPointerException( "message is null" );
        }

        this.setSource( source );

        this.setName( name );

        this.setGroup( group );

        this.setMessage( message );

        this.setStackTraceWriter( stackTraceWriter );
    }

    public void setSource( String source )
    {
        this.source = source;
    }
    
    /**
     * @deprecated Use {@link #getSourceName()} instead
     */
    public Object getSource()
    {
        return getSourceName();
    }

    public String getSourceName()
    {
        return source;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void setGroup( String group )
    {
        this.group = group;
    }

    public String getGroup()
    {
        return group;
    }

    public void setMessage( String message )
    {
        this.message = message;
    }

    public String getMessage()
    {
        return message;
    }

    public void setStackTraceWriter( StackTraceWriter stackTraceWriter )
    {
        this.stackTraceWriter = stackTraceWriter;
    }

    public StackTraceWriter getStackTraceWriter()
    {
        return stackTraceWriter;
    }

    public boolean equals( Object obj )
    {
        if ( obj instanceof ReportEntry == false )
        {
            return false;
        }
        if ( this == obj )
        {
            return true;
        }
        ReportEntry rhs = (ReportEntry) obj;
        return new EqualsBuilder()
            .append( getSourceName(), rhs.getSourceName() )
            .append( getName(), rhs.getName() )
            .append( getGroup(), rhs.getGroup() )
            .append( getMessage(), rhs.getMessage() )
            .append( getStackTraceWriter(), rhs.getStackTraceWriter() )
            .isEquals();
    }

    public String toString()
    {
        return new ToStringBuilder( this )
            .append( "source", getSourceName() )
            .append( "name", getName() )
            .append( "group", getGroup() )
            .append( "message", getMessage() )
            .append( "stackTraceWriter", getStackTraceWriter() )
            .toString();
    }

    public int hashCode()
    {
        // you pick a hard-coded, randomly chosen, non-zero, odd number
        // ideally different for each class
        // good resource at http://primes.utm.edu/lists/small/1000.txt
        return new HashCodeBuilder( 5897, 6653 )
            .append( getSourceName() )
            .append( getName() )
            .append( getGroup() )
            .append( getMessage() )
            .append( getStackTraceWriter() )
            .toHashCode();
    }

}
